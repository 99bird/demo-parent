package cn.itlz.swagger.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author Liuzd QQ：77822013  2019/3/31 0031
 */
@ApiModel(description = "响应类")
@Data
public class SimpleResponse {
    @ApiModelProperty("响应信息")
    private String msg = "这是响应信息";
    @ApiModelProperty("响应数据")
    private Object data = new ArrayList<>();
}
