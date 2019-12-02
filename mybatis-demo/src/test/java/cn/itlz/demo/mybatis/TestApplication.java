package cn.itlz.demo.mybatis;

import cn.itlz.demo.mybatis.dao.UserMapper;
import cn.itlz.demo.mybatis.dto.UserDto;
import cn.itlz.demo.mybatis.entity.UserEntity;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuzd <QQ: 77822013> 2019/9/4 0004
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestApplication {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test() {
        UserDto user = userMapper.getUser();
        System.out.println(user);
    }

    @Test
    public void testPage() {
        Page p = new Page(1,2);
        IPage<UserEntity> userPage = userMapper.getUserPage(p);
        System.out.println(userPage);
    }

    @Test
    public void getUserList() {
        List<UserDto> userDtos = userMapper.getUserList();
        System.out.println(userDtos);
    }

    @Test
    public void update() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(24);
        userMapper.update(userEntity, new UpdateWrapper<UserEntity>().eq("name", "kangkang"));
    }
}
