package cn.itlz.demo.webflux.handler;

import cn.itlz.demo.webflux.dto.response.SimpleResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
public class TestHandler  {

    public Mono<ServerResponse> getTime() {
        return ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> handle(ServerRequest request) {
        return ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse>hello(ServerRequest request) {
        return ok().
                contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(new SimpleResponse("对方的")), SimpleResponse.class);
    }
}
