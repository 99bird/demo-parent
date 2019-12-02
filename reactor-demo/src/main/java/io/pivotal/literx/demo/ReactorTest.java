package io.pivotal.literx.demo;

import reactor.core.publisher.Flux;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
public class ReactorTest {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 5);
        flux.subscribe(System.out::println);
    }
}
