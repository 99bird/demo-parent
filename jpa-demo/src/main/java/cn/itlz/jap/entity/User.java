package cn.itlz.jap.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Entity
@Data
@Table(name = "user1")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(targetEntity = Course.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Course> courses;
}
