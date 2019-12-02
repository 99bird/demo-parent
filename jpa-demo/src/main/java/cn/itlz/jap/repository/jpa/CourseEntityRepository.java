package cn.itlz.jap.repository.jpa;

import cn.itlz.jap.dto.response.CourseDto;
import cn.itlz.jap.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/17 0017
 */
public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {

    @Query("select new cn.itlz.jap.dto.response.CourseDto(c.name,u.name) from CourseEntity c left join UserEntity u on c.userId = u.id")
    List<CourseDto> getCourseDtos();

}
