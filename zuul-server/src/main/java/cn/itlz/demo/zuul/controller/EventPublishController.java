package cn.itlz.demo.zuul.controller;

import cn.itlz.demo.zuul.event.EmailEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
@RestController
public class EventPublishController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @GetMapping("/register")
    public String register() throws InterruptedException {
        System.out.println("做的第一件事");
        this.publisher.publishEvent(new EmailEvent("向aaa发送邮件"));
        System.out.println("做的第二件事");
        return "Success";
    }
}
