package cn.itlz.demo.webflux;

import cn.itlz.demo.webflux.dto.request.UserParamDto;
import cn.itlz.demo.webflux.entity.User;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/25 0025
 */
public class MainTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        User user = new User();
        user.setUserName("zhangsan");

        /*for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("name"+i);
            user.setAge(i);
            userList.add(user);
        }*/

        List<UserParamDto> userParamDtos = new ArrayList<>();

//        UserParamDto userParamDto = new UserParamDto();

        long start = System.currentTimeMillis();

        /*for (User user1 : userList) {
            UserParamDto userParamDto = new UserParamDto();
            BeanUtils.copyProperties(user1,userParamDto);
            userParamDtos.add(userParamDto);
        }*/
        UserParamDto userParamDto = new UserParamDto();
//        BeanUtils.copyProperties(user,userParamDto);
//        userParamDto.setUserName(user.getUserName());
        BeanCopier.create(user.getClass(), userParamDto.getClass(), false);

        long end = System.currentTimeMillis();

        long result = end - start;

        System.out.println(result);
//        BeanUtils.copyProperties(user,userParamDtos);

        System.out.println(userParamDto);
    }
}
