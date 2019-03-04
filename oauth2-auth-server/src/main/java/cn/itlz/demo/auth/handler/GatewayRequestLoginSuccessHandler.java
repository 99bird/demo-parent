package cn.itlz.demo.auth.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当通过网关登录成功后的处理器
 * @author Liuzd QQ: 77822013
 * @since 2018/12/9 0009
 */
public class GatewayRequestLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final Log logger = LogFactory.getLog(this.getClass());

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        //TODO 当直接访问认证服务器的登录页面，登录成功后的处理逻辑
        if (savedRequest == null) {
            super.onAuthenticationSuccess(request, response, authentication);
            logger.info("savedRequest is null");
            return;
        }
        String targetUrlParameter = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl()
                || (targetUrlParameter != null && StringUtils.hasText(request
                .getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);

            return;
        }

        clearAuthenticationAttributes(request);

        String targetUrl = savedRequest.getRedirectUrl();
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(targetUrl)
                .host("localhost")
                .port(8088)
                .replacePath("passport/oauth/authorize")
                .build();

        getRedirectStrategy().sendRedirect(request, response, uriComponents.toUriString());
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}
