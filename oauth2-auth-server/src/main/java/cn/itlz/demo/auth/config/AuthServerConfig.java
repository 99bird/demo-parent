package cn.itlz.demo.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.annotation.PostConstruct;

/**
 * @author Liuzd <QQ: 77822013> 2019/6/19 0019
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfig {

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private UserDetailsService userDetailsService;



    @PostConstruct
    public void init() throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService);
    }
}
