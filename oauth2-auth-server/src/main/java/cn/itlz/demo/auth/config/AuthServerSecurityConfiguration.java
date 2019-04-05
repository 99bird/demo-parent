package cn.itlz.demo.auth.config;

import cn.itlz.demo.auth.handler.GatewayRequestLoginSuccessHandler;
import cn.itlz.demo.auth.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 认证服务器安全配置
 * @author Liuzd QQ: 77822013
 * @since 2018/12/4 0004
 */
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class AuthServerSecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
//                .loginPage("http://localhost:8088/passport/login.html")
                .loginPage("http://localhost:8001/login.html")
                .loginProcessingUrl("/login")
//                .successHandler(gatewayRequestLoginSuccessHandler())
//                .successHandler(authenticationSuccessHandler())
                .and()
                .authorizeRequests().antMatchers("/login.html", "/login", "/require", "/loginRedirect", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    private GatewayRequestLoginSuccessHandler gatewayRequestLoginSuccessHandler() {
        GatewayRequestLoginSuccessHandler gatewayRequestLoginSuccessHandler = new GatewayRequestLoginSuccessHandler();
        gatewayRequestLoginSuccessHandler.setDefaultTargetUrl("http://localhost:3000");
        return gatewayRequestLoginSuccessHandler;
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler() {
        MyAuthenticationSuccessHandler myAuthenticationSuccessHandler =
                new MyAuthenticationSuccessHandler();
        myAuthenticationSuccessHandler.setDefaultTargetUrl("http://localhost:3000");
        return myAuthenticationSuccessHandler;
    }
}
