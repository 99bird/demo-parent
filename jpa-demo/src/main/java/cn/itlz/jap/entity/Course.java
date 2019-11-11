package cn.itlz.jap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Liuzd QQ: 77822013 2019/4/17 0017
 */
@Data
@Entity
@Table(name = "course")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "id",referencedColumnName = "user_id")
//    private User user;
}
