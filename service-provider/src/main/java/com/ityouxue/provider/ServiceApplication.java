package com.ityouxue.provider;

import com.ityouxue.provider.dto.response.SimpleResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Liuzd QQ: 77822013 2019/1/31 0031
 */
@SpringBootApplication
@RestController
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @GetMapping("/test")
    public String getMsg()  {

        System.out.println("这是中文");
        return "hello！ 我是无我科技 java组 刘则地 "+new Date();
    }

    @GetMapping("test2")
    public ResponseEntity test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        SimpleResponse response = new SimpleResponse();
        response.setData(list);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @GetMapping(path="/events", produces= MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter handle() {
        SseEmitter emitter = new SseEmitter();
        // Save the emitter somewhere..
        new Thread(()->{
            // In some other thread
            try {
                emitter.send("Hello once");
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                emitter.send("Hello once");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();


        new Thread(()->{
            // In some other thread
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        return emitter;
    }




}
