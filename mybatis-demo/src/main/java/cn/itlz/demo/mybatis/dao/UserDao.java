package cn.itlz.demo.mybatis.dao;

import cn.itlz.demo.mybatis.dto.UserDto;
import cn.itlz.demo.mybatis.dto.UserInfo;
import cn.itlz.demo.mybatis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liuzd QQ：77822013  2019/3/4 0004
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    @Select("select * from user where id = 1")
    UserDto getUser();

    @Select("select u.name,s.score from user as u,score as s where u.id=#{id} and s.id=1")
    UserInfo getUserInfo(Integer id);

    //    List<User> getUserByPage(Pagination pagination);
    @Select("select * from user")
    List<UserDto> getUserDtoByPage(Page<UserDto> page);

}
