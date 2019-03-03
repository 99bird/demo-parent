package cn.itlz.demo.beanscope.controller;

import cn.itlz.demo.beanscope.beans.ScopeBeanTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/5 0005
 */
@RestController
public class TestController {

    @Autowired
    @Qualifier("requestScopeBean")
    private ScopeBeanTest requestScopeBean;

    @Autowired
    @Qualifier("sessionScopeBean")
    private ScopeBeanTest sessionScopeBean;

    @GetMapping("/visitR")
    public String visitRequestBean() {
        return requestScopeBean.toString();
    }

    @GetMapping("/changeR")
    public String changeRequestBeanState() {
        requestScopeBean.setState("you have changed the request scope bean!");
        return requestScopeBean.toString();
    }

    @GetMapping("/visitS")
    public String visitSessionBean() {
        return sessionScopeBean.toString();
    }

    @GetMapping("/changeS")
    public String changeSessionBeanState() {
        sessionScopeBean.setState("you have changed the session scope bean!");
        return sessionScopeBean.toString();
    }
}
