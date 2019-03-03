package cn.itlz.demo.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/9 0009
 */
public class Value {
    private int val = 0;

    private List<ChangeValueEventListener> listeners = new ArrayList<>();

    public void changeVal(int change) {
        this.val = val + change;
        publishEvent(new ChangeValueEvent(val));

    }

    public void addChangeValueEventListener(ChangeValueEventListener listener) {
        this.listeners.add(listener);
    }

    private void publishEvent(ChangeValueEvent event) {
        for (ChangeValueEventListener listener : listeners) {
            listener.changeValue(event);
        }
    }
}
