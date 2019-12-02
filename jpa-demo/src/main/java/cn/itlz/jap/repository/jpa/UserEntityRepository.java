package cn.itlz.jap.repository.jpa;

import cn.itlz.jap.dto.response.UserDto;
import cn.itlz.jap.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {

    @Query("select new cn.itlz.jap.dto.response.UserDto(u.id,u.name) from User u ")
    List<UserDto> getUsers();

    List<UserEntity> findByIdIn(Set<Long> ids);
}
