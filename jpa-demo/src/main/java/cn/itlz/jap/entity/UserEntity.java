package cn.itlz.jap.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Entity
@Data
@Table(name = "user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;
}
