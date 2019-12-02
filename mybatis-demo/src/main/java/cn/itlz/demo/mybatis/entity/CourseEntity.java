package cn.itlz.demo.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuzd <QQ: 77822013> 2019/9/4 0004
 */
@TableName("course")
@Data
public class CourseEntity {

    private Long id;
    private String name;
}
