package cn.itlz.jap.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Data
public class UserDto {

    public interface View {}

    private Long id;

//    @JsonView(View.class)
//    @JsonIgnoreProperties
    @JsonIgnore
    private String name;
}
