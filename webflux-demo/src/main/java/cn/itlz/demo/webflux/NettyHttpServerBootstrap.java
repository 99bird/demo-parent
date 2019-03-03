package cn.itlz.demo.webflux;

import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServer;
import reactor.ipc.netty.tcp.BlockingNettyContext;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * 手动启动NettyWebServer并添加RouterFunction和HandlerFunction
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
public class NettyHttpServerBootstrap {

    //初始化handlerFunction，相当于Controller
    private HandlerFunction<ServerResponse> timeFunction =
            request -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                    Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);

    //初始化routerFunction，就相当于RequestMapping
    private RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(RequestPredicates.GET("/time"), timeFunction);

    private void start() {
        //处理器，和Controller类似
        HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);

        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        HttpServer httpServer =HttpServer.create("127.0.0.1", 9999);
        BlockingNettyContext context = httpServer.start(adapter, Duration.ofMillis(40000));
        startDaemonAwaitThread(context);
        NettyWebServer nettyWebServer = new NettyWebServer(httpServer, adapter, Duration.ofHours(1));
        nettyWebServer.start();
    }

    /**
     * 让线程阻塞，否则启动后就会立即结束
     * @param nettyContext 服务上下文
     */
    private void startDaemonAwaitThread(BlockingNettyContext nettyContext) {
        Thread awaitThread = new Thread("server") {

            @Override
            public void run() {
                nettyContext.getContext().onClose().block();
            }

        };
        awaitThread.setContextClassLoader(getClass().getClassLoader());
        awaitThread.setDaemon(false);
        awaitThread.start();
    }
    public static void main(String[] args) {
        new NettyHttpServerBootstrap().start();
    }
}
