package cn.itlz.profile;

import cn.itlz.profile.config.TestConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
@SpringBootApplication
@EnableConfigurationProperties(cn.itlz.profile.config.TestConfigurationProperties.class)
@RestController
public class ProfileTestApplication {

    @Autowired
    private TestConfigurationProperties testConfigurationProperties;

    public static void main(String[] args) {
        SpringApplication.run(ProfileTestApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return testConfigurationProperties.getA();
    }
}
