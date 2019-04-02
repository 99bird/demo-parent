package cn.itlz.demo.mybatis.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Liuzd QQ：77822013  2019/3/8 0008
 */
@RestController
public class ExcController {

    @GetMapping("/a")
    public String test() {
        throw new RuntimeException("error");
//        return "controller";
    }

    @PostMapping("/aa")
    public Map test2(@RequestBody Map params) {
        return params;
    }
}
