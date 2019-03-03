package cn.itlz.demo.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/7 0007
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(20000);
            return "这是异步做的事";
        });
        new Thread(task).start();

        System.out.println("主线程执行完毕！");
        System.out.println(task.get());
    }
}
