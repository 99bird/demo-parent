package cn.itlz.demo.zuul.controller;

import cn.itlz.demo.zuul.client.TestFeignClient;
import cn.itlz.demo.zuul.dto.response.Article;
import cn.itlz.demo.zuul.dto.response.People;
import cn.itlz.demo.zuul.dto.response.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/12/11 0011
 */
@RestController
public class TestController {

    @Autowired
    private TestFeignClient testFeignClient;
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello() throws ExecutionException, InterruptedException {
//        return new SimpleResponse("hello");

         Map<Integer, FutureTask<String>> map = new HashMap<>();
        for (int i=0;i<10;i++) {
            FutureTask<String> futureTask = new FutureTask<>(()->{
                return testFeignClient.getVal();
            });
            map.put(i, futureTask);
            new Thread(futureTask).start();
        }

        for (int i=0;i<10;i++) {
            FutureTask<String> task = map.get(i);
            String size =  task.get();
            System.out.println(size);
        }

        return "Success";
    }

    @GetMapping("/people")
    public People getPeople() {

        logger.info("请求进入后端");

        People people = new People();
        people.setName("Liuzd");
        people.setHeight("1.83");
        people.setAge(24);
        return people;
    }

    @GetMapping("/article")
    public Article getArticle() {
        logger.info("请求进入后端 getArticle");

        Article article = new Article();
        article.setTitle("RXjava学习");
        article.setDesc("这是最好的rxjava学习资料");
        article.setContent("嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        return article;
    }
}
