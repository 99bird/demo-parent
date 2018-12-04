package cn.itlz.demo.controller;

import cn.itlz.demo.dto.response.SimpleResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/2 0002
 */
@RestController
public class MyController {

    @GetMapping("/normalReq")
    public SimpleResponse normal() {
        return new SimpleResponse("hello");
    }

    @GetMapping("/errorReq")
    public SimpleResponse error() throws InterruptedException {
        Thread.sleep(10000);
        return new SimpleResponse("error");
    }

}
