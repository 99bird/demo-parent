package cn.itlz.demo.webflux.router;

import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */

public class TestRouter implements RouterFunction<ServerResponse> {

    @Override
    public Mono<HandlerFunction<ServerResponse>> route(ServerRequest request) {
        return null;
    }
}
