package cn.itlz.demo.webflux.controller;

import cn.itlz.demo.webflux.dto.request.UserParamDto;
import cn.itlz.demo.webflux.dto.response.SimpleResponse;
import cn.itlz.demo.webflux.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Liuzd QQ: 77822013
 * @since 2019/1/8 0008
 */
@RestController
public class HelloController {

    @GetMapping("/getInfo")
    public SimpleResponse hello(ServerHttpRequest request) {

        HttpHeaders headers = request.getHeaders();
//        System.out.println(headers);

        long start = System.currentTimeMillis();
        User user = new User();
        user.setUserName("zhangsan");
        UserParamDto userParamDto = new UserParamDto();
        BeanUtils.copyProperties(user,userParamDto);
        System.out.println(userParamDto);
        long end = System.currentTimeMillis();

        long result = end - start;
        System.out.println(result);
        /*Flux<DataBuffer> flux = request.getBody();

        *//*AtomicReference<String> bodyRef = new AtomicReference<>();
        flux.subscribe(buffer -> {
            CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer.asByteBuffer());
            DataBufferUtils.release(buffer);
            bodyRef.set(charBuffer.toString());});*//*
        flux.subscribe(d->{
//            System.out.println(d);
            InputStream inputStream = d.asInputStream();
            byte[] bytes = null;
            try {
                bytes =  inputStream.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(bytes));
            System.out.println("dlkjdfld");
        });

        Flux<String> stringFlux = Flux.just("aaa", "dddd");
        stringFlux.subscribe(s->{
            System.out.println(s);
        });

        Flux<String> stringFlux1 = Flux.empty();
        stringFlux1.subscribe(s->{
            System.out.println("kong");
            System.out.println(s);
        });*/

//        System.out.println(bodyRef.get());
        return new SimpleResponse("李四");
    }

    @GetMapping("getMono")
    public Mono<SimpleResponse> hello2() {
        return Mono.just(new SimpleResponse("王五"));
    }

    @GetMapping("getRes")
    public ResponseEntity<Object> getResponse() {
        return new ResponseEntity<>("res", HttpStatus.OK);
    }
}
