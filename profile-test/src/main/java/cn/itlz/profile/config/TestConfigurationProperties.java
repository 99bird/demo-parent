package cn.itlz.profile.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
@ConfigurationProperties("cn.itlz")
public class TestConfigurationProperties {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
