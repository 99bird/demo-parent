package cn.itlz.jap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

//    public interface View {}

    private Long id;

//    @JsonView(View.class)
//    @JsonIgnoreProperties
//    @JsonIgnore
    private String name;

    public UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private String courseName;
}
