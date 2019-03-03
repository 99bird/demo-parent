package cn.itlz.rxjava;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        /*list.forEach(a->{
            System.out.println(a);
        });*/
        list.forEach(System.out::println);
    }
}
