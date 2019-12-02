package cn.itlz.demo.webflux.router;

import cn.itlz.demo.webflux.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
@Configuration
public class RouterConfig {

    private TestHandler testHandler = new TestHandler();

    @Bean
    public RouterFunction<ServerResponse> testRouter() {
        return route(GET("/h1/{id}"), request -> testHandler.hello(request));
    }
}
