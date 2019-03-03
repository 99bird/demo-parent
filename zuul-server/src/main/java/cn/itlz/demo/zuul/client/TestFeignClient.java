package cn.itlz.demo.zuul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Liuzd QQ: 77822013 2019/1/31 0031
 */
@FeignClient(name = "myServer",url = "http://localhost:9009")
public interface TestFeignClient {

    @GetMapping("/test")
    public String getVal();
}
