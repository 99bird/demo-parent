package cn.itlz.rxjava;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
public class Test {

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new A("aaa"));
        list.add(new A("bbb"));
        list.add(new A("ccc"));
        list.forEach(a-> System.out.println(a.getName()));
//        list.forEach(System.out::println);
    }

}
@Data
@AllArgsConstructor
class A{
    private String name;

}
