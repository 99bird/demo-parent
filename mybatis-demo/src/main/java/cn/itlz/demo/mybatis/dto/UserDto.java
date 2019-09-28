package cn.itlz.demo.mybatis.dto;

import cn.itlz.demo.mybatis.entity.CourseEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Liuzd QQ：77822013  2019/3/4 0004
 */
@ToString
@Data
public class UserDto {
    private Long id;
    private String username;
    private Integer age;

    private List<CourseEntity> courseEntityList;
}
