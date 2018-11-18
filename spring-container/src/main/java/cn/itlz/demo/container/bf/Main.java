package cn.itlz.demo.container.bf;

import cn.itlz.demo.container.component.Hello;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * Desc: Create {@link BeanFactory} manually
 * @author Liuzd
 * @since 2018/11/18 0018
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new GenericBeanDefinition();
        ((GenericBeanDefinition) beanDefinition).setBeanClass(Class.forName("cn.itlz.demo.container.component.Hello"));

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("hello",beanDefinition);

        //在这下面打断点，可以看到，当getBean方法执行时Hello对象实例化
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();

    }
}
