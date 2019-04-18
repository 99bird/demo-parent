package cn.itlz.jap.repository.jpa;

import cn.itlz.jap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
public interface UserRepository extends JpaRepository<User,Long> {

//    @Query("select new cn.itlz.jap.dto.response.UserDto(u.id,u.name) from User u where u.id=1")
//    @Query(value = "select * from user u where u.id=1",nativeQuery = true)
//    UserDto getUserDto();
}
