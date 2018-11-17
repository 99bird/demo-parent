package cn.itlz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/10 0010
 */
@ConfigurationProperties("test")
public class TestProperties {

    private String hello;

    private String itlz;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getItlz() {
        return itlz;
    }

    public void setItlz(String itlz) {
        this.itlz = itlz;
    }
}
