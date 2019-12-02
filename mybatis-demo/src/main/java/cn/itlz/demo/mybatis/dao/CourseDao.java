package cn.itlz.demo.mybatis.dao;

import cn.itlz.demo.mybatis.dto.CourseDto;
import cn.itlz.demo.mybatis.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/5/13 0013
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

    @Select("select c.name , u.name as userName from course c left join user u on c.user_id = u.id")
    List<CourseDto> getCourse();

}
