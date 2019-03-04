package cn.itlz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
@WebFilter("/*")
public class MyFilterOne implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        response.getWriter().print("<h1>hello</h1>");
        System.out.println("myFilterOne");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
