package cn.itlz.demo.reactor;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liuzd QQ: 77822013 2019/3/10 0010
 */
public class NettyServerBootstrap {

    //初始化handlerFunction，相当于Controller
    private HandlerFunction<ServerResponse> timeFunction =
            request -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                    Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);

    //初始化routerFunction，就相当于RequestMapping
    private RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(RequestPredicates.GET("/time"), timeFunction);

    private void start() {
        HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        HttpServer.create()
                .host("0.0.0.0")
                .port(80)
                .handle(adapter).bind().block();
    }

    public static void main(String[] args) {
        new NettyServerBootstrap().start();
    }
}
