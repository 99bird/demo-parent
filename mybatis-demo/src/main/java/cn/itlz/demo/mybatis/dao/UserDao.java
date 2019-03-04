package cn.itlz.demo.mybatis.dao;

import cn.itlz.demo.mybatis.dto.UserDto;
import cn.itlz.demo.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Liuzd QQ：77822013  2019/3/4 0004
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user where id = 1")
    UserDto getUser();
}
