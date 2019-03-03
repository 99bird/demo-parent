package cn.itlz.demo.configclient.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/3 0003
 */
@Configuration
@EnableConfigurationProperties(ConfigurationInfoProperties.class)
public class MyConfiguration {

    private ConfigurationInfoProperties configurationInfoProperties;

    public MyConfiguration(ConfigurationInfoProperties configurationInfoProperties) {
        this.configurationInfoProperties = configurationInfoProperties;
    }

    public ConfigurationInfoProperties getConfigurationInfoProperties() {
        return configurationInfoProperties;
    }

    public void setConfigurationInfoProperties(ConfigurationInfoProperties configurationInfoProperties) {
        this.configurationInfoProperties = configurationInfoProperties;
    }
}
