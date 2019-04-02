/*
package cn.itlz.demo.webflux;

import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServer;
import reactor.ipc.netty.tcp.BlockingNettyContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

*/
/**
 * NettyWebServer的另外一种启动方式，直接在当前线程中阻塞
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 *//*

public class NettyHttpServerBootstrap2 {
    public static void main(String[] args) {
        HandlerFunction<ServerResponse> timeFunction =
                request -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                        Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);

        RouterFunction<ServerResponse> routerFunction = RouterFunctions.route(GET("/time"), timeFunction);
        HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        BlockingNettyContext server = HttpServer.create(9999).start(adapter);
        server.getContext().onClose().block();
    }
}
*/
