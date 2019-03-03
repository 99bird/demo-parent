package cn.itlz.config;

import cn.itlz.filter.MyFilter;
import cn.itlz.filter.MyFilterOne;
import cn.itlz.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class Config {

    /*@Autowired
    @Qualifier("springSecurityFilterChain")
    private Filter filter;*/

    @Autowired
    @Qualifier("myFilterChain")
    private DefaultSecurityFilterChain defaultSecurityFilterChain;

    /**
     * 这个方法是打印filter
     */
    /*@PostConstruct
    public void postConstruct() {
        System.out.println("hello");
        System.out.println(filter);
    }*/

    @Bean("myFilterChainProxy")
    public FilterChainProxy filterChainProxy() {
        return new FilterChainProxy(defaultSecurityFilterChain);
    }

    @Bean("myFilterChain")
    public DefaultSecurityFilterChain defaultSecurityFilterChain() {
        RequestMatcher requestMatcher = AnyRequestMatcher.INSTANCE;
        MyFilter myFilter = new MyFilter();
        MyFilterOne myFilterOne = new MyFilterOne();
        return new DefaultSecurityFilterChain(requestMatcher, myFilter, myFilterOne);
    }

    /**
     * 这是用来测试{@link ConditionalOnBean}注解的,@ConditionalOnBean标注在一个方法上
     * 即使这个bean还没有创建，但是也能也能返回true
     * @return SomeService
     */
    @Bean
    @Qualifier("someService")
    public SomeService someService() {
        return new SomeService();
    }

    @Bean
    @Qualifier("myFitlterChainDelegator")
    @ConditionalOnBean(name = "someService")
    public DelegatingFilterProxyRegistrationBean delegatingFilterProxyRegistrationBean() {
        DelegatingFilterProxyRegistrationBean registrationBean =
                new DelegatingFilterProxyRegistrationBean("myFilterChainProxy");
        System.out.println("ceshi");
        return registrationBean;
    }


}
