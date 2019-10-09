package cn.itlz.java;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liuzd <QQ: 77822013> 2019/9/28 0028
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureDemo futureDemo = new FutureDemo();
        futureDemo.simpleFuture();

    }

    private void simpleFuture() throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {                    //创建要执行的
            @Override
            public String call() throws Exception {
                System.out.println("hheo");
                return "hello";
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);             //把要执行的创建为FutureTask（任务）

        new Thread(futureTask).start();                                         //执行

        System.out.println(futureTask.get());                                   //获取执行结果
    }
}
