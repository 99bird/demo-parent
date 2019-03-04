package cn.itlz.demo.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/5 0005
 */
@SpringBootApplication
//@EnableZuulProxy
//@EnableDiscoveryClient
@EnableFeignClients
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
