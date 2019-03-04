package cn.itlz.demo.zuul.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/6 0006
 */
public class EmailEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }
}
