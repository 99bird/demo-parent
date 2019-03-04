package cn.itlz.demo.thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/7 0007
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(5000);
            return "这是Callable返回值";
        });
        System.out.println("任务提交到线程池中，等待执行完毕");
        System.out.println(future.get());
    }
}
