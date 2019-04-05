package cn.itlz.rbac.config;

import cn.itlz.rbac.permission.PermissionCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * @author Liuzd QQ: 77822013 2019/3/23 0023
 */
@Configuration
//@EnableAuthorizationServer
//@EnableResourceServer
public class ServerConfig {


    @Bean
    public PermissionCheck permissionCheck() {
        return new PermissionCheck();
    }


   /* @Configuration
    static class AuthConfig extends ResourceServerConfigurerAdapter {

    }*/

    /**
     * 资源服务器配置
     */
    @Configuration
    static class  ResourceConfig extends ResourceServerConfigurerAdapter{

        @Autowired
        private OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/test2/**").access("@permissionCheck.check(authentication,httpServletRequest)")
                    .anyRequest().authenticated();

        }

        @Bean
        public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
            OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
            expressionHandler.setApplicationContext(applicationContext);
            return expressionHandler;
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.expressionHandler(oAuth2WebSecurityExpressionHandler);
        }
    }




}
