package cn.itlz.demo.configclient2.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/3 0003
 */
@ConfigurationProperties(prefix = "cn.itlz")
public class ConfigurationInfoProperties {

    private String configValue;

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }
}
