package cn.itlz.gateway.demo.config;

import cn.itlz.gateway.demo.filter.TestFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liuzd QQ: 77822013 2019/4/22 0022
 */
@Configuration
public class ServerConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r->r.path("/bbb/*").uri("lb://service-provider/").id("service-provider"))
                .build();
    }

    @Bean
    public TestFilter testFilter() {
        return new TestFilter();
    }

}
