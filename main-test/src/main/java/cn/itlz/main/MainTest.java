package cn.itlz.jap;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Liuzd QQ：77822013  2019/4/18 0018
 */
public class MainTest {

    public static void main(String[] args) {
        HashSet<Apple> set = new HashSet<>();
        LinkedList<Apple> list = new LinkedList<>();

        Long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            set.add(new Apple(i));
        }
        Long end = System.currentTimeMillis();

        long result = end - start;
        System.out.println("插入set-----------"+result);


        Long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(new Apple(i));
        }
        Long end1 = System.currentTimeMillis();

        long result1 = end1 - start1;

        System.out.println("插入list-----------"+ result1);

        Long readStart = System.currentTimeMillis();
        Iterator<Apple> iterator = set.iterator();
        while (iterator.hasNext()) {
            Apple apple = iterator.next();
        }
        Long readEnd = System.currentTimeMillis();

        long resultRead = readEnd - readStart;
        System.out.println("读取set-----------"+resultRead);

        Long readStart1 = System.currentTimeMillis();

        for (Apple apple : list) {
            Apple apple1 = apple;
        }
        Long readEnd1 = System.currentTimeMillis();

        long resultRead1 = readEnd1 - readStart1;
        System.out.println("读取list-----------"+resultRead1);

    }


}

@AllArgsConstructor
class Apple{
    private Integer num;
}
