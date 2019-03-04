package cn.itlz.demo.configclient2.controller;

import cn.itlz.demo.configclient2.configuration.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/3 0003
 */
@RestController
public class TestController {

    @Autowired
    private MyConfiguration myConfiguration;

    @GetMapping("/config")
    public String getConfigInfo() {
        return myConfiguration.getConfigurationInfoProperties().getConfigValue();
    }
}
