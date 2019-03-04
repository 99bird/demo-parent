package cn.itlz.demo.event;

import java.util.EventListener;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/9 0009
 */
public interface ChangeValueEventListener extends EventListener {
    void changeValue(ChangeValueEvent e);
}
