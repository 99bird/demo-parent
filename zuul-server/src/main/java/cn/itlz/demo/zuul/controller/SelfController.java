package cn.itlz.demo.zuul.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
@RestController
public class SelfController {

    @GetMapping("/self")
    public Authentication getSelfInfo() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
