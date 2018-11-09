package cn.itlz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "正常访问Spring boot";
    }
}
