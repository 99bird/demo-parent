package cn.itlz.demo.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Liuzd QQ: 77822013 2019/5/13 0013
 */
@Data
@TableName("course")
public class Course {

    @TableId
    private Long id;

    private String name;

    private Long userId;
}
