package cn.itlz.demo.event;

import java.util.EventObject;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/9 0009
 */
public class ChangeValueEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ChangeValueEvent(Object source) {
        super(source);
    }
}
