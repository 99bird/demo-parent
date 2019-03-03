package cn.itlz.demo.zuul.listenner;

import cn.itlz.demo.zuul.event.EmailEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
@Component
@EnableAsync
public class EmailEventListener {

    @EventListener
    @Async
    public void processEmailEvent(EmailEvent event) {
        System.out.println("Do some hard thing....");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(event.getSource());
        System.out.println("这件事终于搞完了");
    }
}
