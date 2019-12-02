package cn.itlz.demo.webflux.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
@Configuration
public class WebFluxConfiguration {

   /* @Bean
    public MyFirstWebfluxFilter myFilter() {
        return new MyFirstWebfluxFilter();
    }*/

    /*@Bean
    public RouterFunction<ServerResponse> testRouter() {
        return RouterFunctions.route(RequestPredicates.GET("/hh"), request -> ok().contentType(MediaType.TEXT_PLAIN)
                .body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class));
    }*/
}
