package cn.itlz.demo.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/17 0017
 */
@Controller
public class LoginRedirectController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/loginRedirect")
    public void loginRedirect(HttpServletRequest request, HttpServletResponse response,String redirectUrl) throws IOException {
        HttpSession session = request.getSession();
        redirectUrl = "http://" + redirectUrl;
        session.setAttribute("redirectUrl",redirectUrl);

        logger.info("重定向url是" + redirectUrl);

        response.sendRedirect("http://localhost:8088/passport/login.html");


    }
}
