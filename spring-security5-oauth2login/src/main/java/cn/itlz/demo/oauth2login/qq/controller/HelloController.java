package cn.itlz.demo.oauth2login.qq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Liuzd
 * @since 2018/11/18 0018
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "success";
    }
}
