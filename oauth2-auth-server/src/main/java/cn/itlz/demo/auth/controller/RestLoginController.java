package cn.itlz.demo.auth.controller;

import cn.itlz.demo.auth.dto.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/10 0010
 */
@RestController
public class RestLoginController {

    @GetMapping("/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse require() {
        return new SimpleResponse("请登录");
    }
}
