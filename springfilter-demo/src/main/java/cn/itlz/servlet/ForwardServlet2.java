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
@WebServlet("/s2")
public class ForwardServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = "<h1>S2</h1>";
        resp.getOutputStream().print(str);
    }
}
