package com.ityouxue.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public String getMsg()  {

        System.out.println("这是中文");
        return "hello！ 我是无我科技 java组 刘则地 "+new Date();
    }
}
