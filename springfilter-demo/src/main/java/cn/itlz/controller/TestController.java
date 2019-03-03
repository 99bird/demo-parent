package cn.itlz.controller;

import cn.itlz.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
@RestController
public class TestController {

    @Autowired
    private TestProperties test;

    @GetMapping("/hello")
    public String hello() {
        return "正常访问Spring boot";
    }

    @GetMapping("/test")
    public TestProperties test() {
        return test;
    }
}
