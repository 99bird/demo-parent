package cn.itlz.demo.webflux.config;

import cn.itlz.demo.webflux.filter.MyFirstWebfluxFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
@Configuration
public class WebFluxConfiguration {

    @Bean
    public MyFirstWebfluxFilter myFilter() {
        return new MyFirstWebfluxFilter();
    }

    @Bean
    public RouterFunction<ServerResponse> testRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/hh"), request -> {
            //模拟线程阻塞
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ok().contentType(MediaType.TEXT_PLAIN)
                    .body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
        });
    }
}
