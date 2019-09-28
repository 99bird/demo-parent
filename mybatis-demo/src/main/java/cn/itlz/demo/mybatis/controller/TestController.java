package cn.itlz.demo.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuzd <QQ: 77822013> 2019/9/20 0020
 */
@RestController
public class TestController {

    @GetMapping("/get")
    public String get(@RequestParam String name) {
        return "success";
    }
}
