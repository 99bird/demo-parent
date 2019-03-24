package cn.itlz.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013 2019/3/24 0024
 */
@RestController
public class Test2Controller {

    @GetMapping("test2")
    public String test2() {
        return "test2";
    }
}
