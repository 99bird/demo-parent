package cn.itlz.rbac.permission;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Liuzd QQ: 77822013 2019/3/24 0024
 */
public class PermissionCheck {

    public boolean check(Authentication authentication, HttpServletRequest request) {
        return false;
    }
}
