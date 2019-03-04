package cn.itlz.demo.webflux.filter;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
public class MyFirstWebfluxFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        System.out.println("webflux filter");
        return chain.filter(exchange);
    }
}
