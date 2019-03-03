package cn.itlz.demo.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/7 0007
 */
public class VolatileTest implements Runnable{

    public static CountDownLatch countDownLatch = new CountDownLatch(10);

    private int val = 10;

//    private int changeVal() {
//        this.val = val - 1;
//        return val;
//    }

    @Override
    public void run() {
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        changeVal();

        val = 1;

        System.out.println(val);

    }

    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(volatileTest).start();
//            countDownLatch.countDown();
        }
    }


}
