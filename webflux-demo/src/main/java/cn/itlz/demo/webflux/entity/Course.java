package cn.itlz.demo.webflux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Course {

    private String id;

    private String courseName;
}
