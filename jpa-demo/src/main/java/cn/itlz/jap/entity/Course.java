package cn.itlz.jap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Liuzd QQ: 77822013 2019/4/17 0017
 */
@Data
@Entity
@Table(name = "course")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Course {

    @Id
    private Long id;

    private String name;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
