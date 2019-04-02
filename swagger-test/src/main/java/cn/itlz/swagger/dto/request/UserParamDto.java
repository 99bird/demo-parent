package cn.itlz.swagger.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Liuzd QQ：77822013  2019/3/31 0031
 */
@Data
public class UserParamDto {

    private Long userId;

    @NotEmpty
    private String msg;

}
