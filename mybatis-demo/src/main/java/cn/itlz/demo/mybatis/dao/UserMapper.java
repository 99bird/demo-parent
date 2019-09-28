package cn.itlz.demo.mybatis.dao;

import cn.itlz.demo.mybatis.dto.UserDto;
import cn.itlz.demo.mybatis.entity.CourseEntity;
import cn.itlz.demo.mybatis.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author liuzd <QQ: 77822013> 2019/9/4 0004
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


    UserDto getUser();

    @Select("select * from user")
    IPage<UserEntity> getUserPage(Page p);

    List<UserDto> getUserList();

}
