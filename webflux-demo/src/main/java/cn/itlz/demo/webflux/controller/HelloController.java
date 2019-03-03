package cn.itlz.demo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
@RestController
public class HelloController {

    @GetMapping("/getInfo")
    public String hello() {
        return "SUCCESS Webflux";
    }
}
