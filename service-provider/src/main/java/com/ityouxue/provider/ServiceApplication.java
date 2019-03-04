package com.ityouxue.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013 2019/1/31 0031
 */
@SpringBootApplication
@RestController
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @GetMapping("/test")
    public String getMsg() throws InterruptedException {

        Thread.sleep(100);
        return "我是服务提供者";
    }
}
