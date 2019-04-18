package cn.itlz.jap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(targetEntity = Course.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Course> courses = new ArrayList<>();
}
