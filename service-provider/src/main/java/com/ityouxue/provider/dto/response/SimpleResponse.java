package com.ityouxue.provider.dto.response;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Liuzd QQ：77822013  2019/3/31 0031
 */
@Data
public class SimpleResponse {
    private String msg = "这是响应信息";
    private Object data = new ArrayList<>();
}
