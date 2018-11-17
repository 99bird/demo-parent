package cn.itlz.demo.config;

import cn.itlz.demo.support.FirstSon;
import cn.itlz.demo.support.SecondSon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/13 0013
 */
@Configuration
public class Config {

    @Bean
    public FirstSon firstSon() {
        return new FirstSon();
    }

    @Bean
    public SecondSon secondSon() {
        return new SecondSon();
    }

}
