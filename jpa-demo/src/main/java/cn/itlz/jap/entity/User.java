package cn.itlz.jap.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Entity
@Data
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private Integer age;
}
