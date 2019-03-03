package cn.itlz.demo.auth.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/17 0017
 */
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String redirectUrl = (String) session.getAttribute("redirectUrl");
        if (redirectUrl == null || redirectUrl.equals("")) {
            response.sendRedirect(getDefaultTargetUrl());
        } else {
            redirectStrategy.sendRedirect(request,response,redirectUrl);
        }
        session.removeAttribute("redirectUrl");
    }
}
