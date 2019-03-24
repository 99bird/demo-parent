package cn.itlz.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013 2019/3/23 0023
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return "hello";
    }
}
