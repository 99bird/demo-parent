package cn.itlz.demo.mybatis.controller;

import cn.itlz.demo.mybatis.dao.UserDao;
import cn.itlz.demo.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Liuzd QQ：77822013  2019/3/4 0004
 */
@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("test")
    public String test() {
        User user = new User();
        user.setName("aa");
        user.setAge(12);
        userDao.insert(user);
        return "success";
    }

    @GetMapping("/getUser")
    public String getUser() {
        User user = userDao.selectById(1);
        return user.toString();
    }

    @GetMapping("getCustom")
    public String getCustomUser() {
        return userDao.getUser().toString();
    }

    @GetMapping("del")
    public int delUser() {
        return userDao.deleteById(1);
    }
}
