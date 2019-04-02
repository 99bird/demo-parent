package cn.itlz.profile.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
@ConfigurationProperties("cn.itlz")
@Data
public class TestConfigurationProperties {

    private String a;

}
