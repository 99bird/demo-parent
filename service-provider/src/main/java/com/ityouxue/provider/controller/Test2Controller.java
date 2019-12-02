package com.ityouxue.provider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
@RestController
public class Test2Controller {

    @GetMapping("t2")
    public ResponseEntity test() {
        return new ResponseEntity<>("ddd", HttpStatus.OK);
    }

    @GetMapping(value = "t3",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String testStream(HttpServletResponse response) throws IOException, InterruptedException {
        /*Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//SSE返回数据格式是固定的以data:开头，以\n\n结束
        return "data:Testing 1,2,3" + r.nextInt() + "\n\n";*/
        ServletOutputStream outputStream = response.getOutputStream();
        new Thread(()->{
            try {
                outputStream.print("ddkdkdkd\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        outputStream.print("1111\nn");

        return "aaa";
    }
}
