package cn.itlz.demo.container.el;

import cn.itlz.demo.container.config.ElConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 两种el表达式的注入bean的方法，主要是因为在Spring 源码中有遇到，看到之后不要陌生就Ok
 * @author Liuzd QQ: 77822013
 * @since 2018/11/21 0021
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ElConfig.class);
        InjectList injectList = (InjectList) applicationContext.getBean("injectList");
        System.out.println(injectList.getList());

        InjectList injectList2 = (InjectList) applicationContext.getBean("injectList2");
        System.out.println(injectList2.getList());
    }
}
