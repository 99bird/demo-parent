package cn.itlz.demo.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Liuzd QQ: 77822013 2019/3/20 0020
 */
@Data
@TableName("sp")
public class Sp {
    private Integer id;
    private String name;
}
