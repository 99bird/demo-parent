package cn.itlz.main;

import cn.itlz.main.exception.MyException;

/**
 * @author Liuzd QQ：77822013  2019/3/8 0008
 */
public class ExceptionTest {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        try {
            test1.t();
        } catch (MyException m) {
            System.out.println("抓住");
        }
    }
}

class Test1{
    public void t() {
        Test2 test2 = new Test2();
        test2.t2();
    }
}


class Test2{
    public void t2() {
        throw new MyException();
    }
}