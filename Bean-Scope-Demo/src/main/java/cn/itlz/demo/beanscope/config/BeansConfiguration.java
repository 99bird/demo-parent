package cn.itlz.demo.beanscope.config;

import cn.itlz.demo.beanscope.beans.ScopeBeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/5 0005
 */
@Configuration
public class BeansConfiguration {

    @Bean("sessionScopeBean")
    @SessionScope
    public ScopeBeanTest SessionScopeBeanTest() {
        ScopeBeanTest SessionScopeBeanTest = new ScopeBeanTest();
        SessionScopeBeanTest.setName("sessionBean");
        SessionScopeBeanTest.setState("initialization");
        return SessionScopeBeanTest;
    }

    @Bean("requestScopeBean")
    @RequestScope
    public ScopeBeanTest requestScopeBean() {
        ScopeBeanTest requestScopeBean = new ScopeBeanTest();
        requestScopeBean.setName("requestBean");
        requestScopeBean.setState("initialization");
        return requestScopeBean;
    }
}
