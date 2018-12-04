package cn.itlz.demo.container.el;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013
 * @since 2018/11/21 0021
 */
public class TestValue {

    public List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("liuzd");
        list.add("测试el方法注入");
        return list;
    }
}
