package cn.itlz.demo.zuul.controller;

import cn.itlz.demo.zuul.dto.response.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/16 0016
 */
@Controller
public class ResponseEntityController {

    @GetMapping("/get")
    public ResponseEntity<SimpleResponse> getEntity() {
        SimpleResponse simpleResponse = new SimpleResponse("dddd");
        ResponseEntity<SimpleResponse> responseEntity = new ResponseEntity<SimpleResponse>(simpleResponse,HttpStatus.OK);
        return responseEntity;
    }
}
