package cn.itlz.demo.mybatis.dao;

import cn.itlz.demo.mybatis.entity.Sp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liuzd QQ：77822013  2019/3/4 0004
 */
@Mapper
public interface SpDao extends BaseMapper<Sp> {

    //    List<User> getUserByPage(Pagination pagination);
    @Select("select * from sp")
    List<Sp> getSpByPage(Page<Sp> page);

    @Select("select * from sp limit #{offset},#{count}")
    List<Sp> getCustomPage(@Param("offset") Integer offset, @Param("count") Integer count);

}
