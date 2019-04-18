package cn.itlz.jap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(targetEntity = Course.class)

    private Set<Course> courses = new HashSet<>();
}
