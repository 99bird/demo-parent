package cn.itlz.demo.thread.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Liuzd <QQ: 77822013> 2019/7/1 0001
 */
public class AsyncMainTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> "result");
        System.out.println(result.get());
    }
}
