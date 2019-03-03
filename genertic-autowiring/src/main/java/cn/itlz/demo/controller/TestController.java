package cn.itlz.demo.controller;

import cn.itlz.demo.service.TestService;
import cn.itlz.demo.support.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/13 0013
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/son")
    public String getSon() {
        for (Parent son : testService.getSons()) {
            son.say();
        }
        return "SUCCESS";
    }

    @GetMapping("/firstSon")
    public String firstSon() {
        return testService.getFirstSon();
    }
}
