package cn.itlz.annotation;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @author Liuzd
 * @since 2018/11/19 0019
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Configuration
public @interface EnableMyConfig {
}
