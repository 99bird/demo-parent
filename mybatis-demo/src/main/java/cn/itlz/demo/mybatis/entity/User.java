package cn.itlz.demo.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author Liuzd QQ: 77822013 2019/3/3 0003
 */
@Data
@ToString
@TableName("user")
public class User {
    @TableId
    private Long id;
    private String name;
    private Integer age;
}
