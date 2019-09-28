package cn.itlz.java;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liuzd <QQ: 77822013> 2019/9/28 0028
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hheo");
                return "hello";
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }
}
