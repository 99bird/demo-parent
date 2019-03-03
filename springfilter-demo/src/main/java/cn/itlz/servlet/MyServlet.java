package cn.itlz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/8 0008
 */
@WebServlet("/ser")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("<h1>hello</h1>");
        resp.sendRedirect("http://localhost:8000/test");
//        resp.sendRedirect("/ser2");
    }
}
