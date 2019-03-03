package cn.itlz.demo.auth.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.OAuth2AuthorizationServerConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

/**
 * 认证服务器的配置
 *
 * @author Liuzd QQ: 77822013
 * @since 2018/12/4 0004
 */
@Configuration
@EnableConfigurationProperties(AuthorizationServerProperties.class)
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final Log logger = LogFactory
            .getLog(OAuth2AuthorizationServerConfiguration.class);

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    private final BaseClientDetails details;

    private final AuthenticationManager authenticationManager;

    private final AuthorizationServerProperties properties;

    public AuthServerConfiguration(BaseClientDetails details,
                                   AuthenticationConfiguration authenticationConfiguration,
                                   AuthorizationServerProperties properties) throws Exception {
        this.details = details;
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
        this.properties = properties;
    }

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder>.ClientBuilder builder = clients
                .inMemory().withClient(this.details.getClientId());
        builder.secret(this.details.getClientSecret())
                .resourceIds(this.details.getResourceIds().toArray(new String[0]))
                .authorizedGrantTypes(
                        this.details.getAuthorizedGrantTypes().toArray(new String[0]))
                .authorities(
                        AuthorityUtils.authorityListToSet(this.details.getAuthorities())
                                .toArray(new String[0]))
                .scopes(this.details.getScope().toArray(new String[0]));

        if (this.details.getAutoApproveScopes() != null) {
            builder.autoApprove(
                    this.details.getAutoApproveScopes().toArray(new String[0]));
        }
        if (this.details.getAccessTokenValiditySeconds() != null) {
            builder.accessTokenValiditySeconds(
                    this.details.getAccessTokenValiditySeconds());
        }
        if (this.details.getRefreshTokenValiditySeconds() != null) {
            builder.refreshTokenValiditySeconds(
                    this.details.getRefreshTokenValiditySeconds());
        }
        if (this.details.getRegisteredRedirectUri() != null) {
            builder.redirectUris(
                    this.details.getRegisteredRedirectUri().toArray(new String[0]));
        }
        builder.autoApprove(true);
    }

    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.accessTokenConverter(this.jwtAccessTokenConverter());
        endpoints.tokenStore(jwtTokenStore());
        if (this.details.getAuthorizedGrantTypes().contains("password")) {
            endpoints.authenticationManager(this.authenticationManager);
        }
    }

    public void configure(AuthorizationServerSecurityConfigurer security)
            throws Exception {
        security.passwordEncoder(NoOpPasswordEncoder.getInstance());
        if (this.properties.getCheckTokenAccess() != null) {
            security.checkTokenAccess(this.properties.getCheckTokenAccess());
        }
        if (this.properties.getTokenKeyAccess() != null) {
            security.tokenKeyAccess(this.properties.getTokenKeyAccess());
        }
        if (this.properties.getRealm() != null) {
            security.realm(this.properties.getRealm());
        }
    }

    @Configuration
    protected static class ClientDetailsLogger {

        private final OAuth2ClientProperties credentials;

        protected ClientDetailsLogger(OAuth2ClientProperties credentials) {
            this.credentials = credentials;
        }

        @PostConstruct
        public void init() {
            String prefix = "security.oauth2.client";
            boolean defaultSecret = this.credentials.isDefaultSecret();
            logger.info(String.format(
                    "Initialized OAuth2 Client%n%n%s.client-id = %s%n"
                            + "%s.client-secret = %s%n%n",
                    prefix, this.credentials.getClientId(), prefix,
                    defaultSecret ? this.credentials.getClientSecret() : "****"));
        }

    }

    @Configuration
    @ConditionalOnMissingBean(BaseClientDetails.class)
    protected static class BaseClientDetailsConfiguration {

        private final OAuth2ClientProperties client;

        protected BaseClientDetailsConfiguration(OAuth2ClientProperties client) {
            this.client = client;
        }

        @Bean
        @ConfigurationProperties(prefix = "security.oauth2.client")
        public BaseClientDetails oauth2ClientDetails() {
            BaseClientDetails details = new BaseClientDetails();
            if (this.client.getClientId() == null) {
                this.client.setClientId(UUID.randomUUID().toString());
            }
            details.setClientId(this.client.getClientId());
            details.setClientSecret(this.client.getClientSecret());
            details.setAuthorizedGrantTypes(Arrays.asList("authorization_code",
                    "password", "client_credentials", "implicit", "refresh_token"));
            details.setAuthorities(
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
            details.setRegisteredRedirectUri(Collections.<String>emptySet());
            return details;
        }

    }

    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("itlz");
        return jwtAccessTokenConverter;
    }

    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

}
