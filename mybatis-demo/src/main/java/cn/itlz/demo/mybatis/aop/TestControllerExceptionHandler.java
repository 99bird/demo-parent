package cn.itlz.demo.mybatis.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Liuzd QQ：77822013  2019/3/8 0008
 */
@ControllerAdvice
public class TestControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String notFount(RuntimeException e) {
        return e.getMessage();
    }
}
