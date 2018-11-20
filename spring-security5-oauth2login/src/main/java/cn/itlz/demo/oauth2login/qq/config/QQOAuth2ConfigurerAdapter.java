package cn.itlz.demo.oauth2login.qq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 用来配置QQ登录的{@link org.springframework.security.config.annotation.web.WebSecurityConfigurer}
 * @author Liuzd QQ: 77822013
 * @since 2018/11/19 0019
 */
@Configuration
public class QQOAuth2ConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login.html","/userinfo")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .loginProcessingUrl("/qqlogin/**")
                .and()
                .csrf().disable();
    }
}
