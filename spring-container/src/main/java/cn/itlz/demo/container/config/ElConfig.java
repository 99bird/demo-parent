package cn.itlz.demo.container.config;

import cn.itlz.demo.container.el.InjectList;
import cn.itlz.demo.container.el.TestValue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/11/21 0021
 */
@Configuration
public class ElConfig {

    @Bean
    public TestValue testValue() {
        return new TestValue();
    }

    @Bean
    public InjectList injectList() {
        return new InjectList();
    }

    @Bean
    @Qualifier("injectList2")
    public InjectList injectList2(@Value("#{testValue.list}") List<String> list) {
        return new InjectList(list);
    }
}
