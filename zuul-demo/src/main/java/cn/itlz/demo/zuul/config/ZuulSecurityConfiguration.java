package cn.itlz.demo.zuul.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/3 0003
 */
@Configuration
@EnableOAuth2Sso
public class ZuulSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login","/client/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
