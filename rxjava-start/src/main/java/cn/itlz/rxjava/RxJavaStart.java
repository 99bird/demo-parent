package cn.itlz.rxjava;

import io.reactivex.Flowable;

/**
 * @author Liuzd QQ: 77822013 2019/2/3 0003
 */
public class RxJavaStart {

    public static void main(String[] args) {
        Flowable.just("Hello Rxjava").subscribe(System.out::println);
    }
}
