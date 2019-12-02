package cn.itlz.demo.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private Long id;

    private String userName;
    private Integer age;
    private String email;

    private List<Course> courses;
}
