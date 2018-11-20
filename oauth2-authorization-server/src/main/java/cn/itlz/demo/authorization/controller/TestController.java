package cn.itlz.demo.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/11/20 0020
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "SUCCESS";
    }
}
