package cn.itlz.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
