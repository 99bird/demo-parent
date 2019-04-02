package cn.itlz.swagger.controller;

import cn.itlz.swagger.dto.request.UserParamDto;
import cn.itlz.swagger.dto.response.SimpleResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Liuzd QQ：77822013  2019/3/31 0031
 */
@Api(value = "用来测试的",tags = {"用户模块"})
@RestController
@RequestMapping("comment")
public class TestController {
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "msg",value = "用户信息")
    })
    @ApiOperation("用户登录接口")
    @PostMapping("1001")
    public SimpleResponse test(@RequestBody @Valid UserParamDto paramDto,String aaa) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setMsg("hello");
        simpleResponse.setData("ssss");
        return simpleResponse;
    }
}
