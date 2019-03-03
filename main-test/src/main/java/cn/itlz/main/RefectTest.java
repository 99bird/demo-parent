package cn.itlz.main;

import cn.itlz.main.interfaces.A;

/**
 * @author Liuzd
 * Desc:
 * Date: 2018/11/11 0011
 */
public class RefectTest {
    public static void main(String[] args) {
        A test = new Test();
        test.test();
    }
}

class Test implements A{

    @Override
    public void test() {
        System.out.println("test");
        test2();
    }

    public void test2() {
        System.out.println("test2");
    }
}