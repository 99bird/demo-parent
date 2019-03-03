package cn.itlz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/9 0009
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter");
        HttpServletResponse response1 = (HttpServletResponse) response;
//        response1.sendRedirect("http://localhost:8080/hello");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
