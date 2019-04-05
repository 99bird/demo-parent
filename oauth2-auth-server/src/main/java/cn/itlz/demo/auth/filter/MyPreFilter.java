package cn.itlz.demo.auth.filter;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013 2019/4/5 0005
 */
public class MyPreFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object o = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(o);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
