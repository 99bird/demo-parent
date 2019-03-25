package cn.itlz.demo.mybatis.controller;

import cn.itlz.demo.mybatis.dao.UserDao;
import cn.itlz.demo.mybatis.dto.UserDto;
import cn.itlz.demo.mybatis.dto.UserInfo;
import cn.itlz.demo.mybatis.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 自定义sql查询
     * @return String
     */
    @GetMapping("getCustom")
    public String getCustomUser() {
        return userDao.getUser().toString();
    }

    @GetMapping("del")
    public int delUser() {
        return userDao.deleteById(1);
    }

    /**
     * 列表+条件 查询
     * @return 列表
     */
    @GetMapping("users")
    public List<User> getUsers() {
        List<User> userList = userDao.selectList(
                new QueryWrapper<User>().eq("name", "bb")
        );
        return userList;
    }

    /**
     * 自定义sql，多表关联查询
     * @return UserInfo 关联数据
     */
    @GetMapping("userInfo")
    public UserInfo getUserInfo() {
        return userDao.getUserInfo(19);
    }

    /**
     * 单表分页查询
     * @return Page数据页
     */
    @GetMapping("getUserByPage")
    public IPage<User> getUserByPage() {
        Page<User> page = new Page<User>().setSize(2).setCurrent(2);
        return userDao.selectPage(
                page,
                Wrappers.emptyWrapper());
    }

    /**
     * 单表分页查询，自定义属性
     * TODO 先根据分页参数查出数据，然后塞进page对象中
     * @return 分页数据
     */
    @GetMapping("getUserDtoByPage")
    public IPage<UserDto> getUserDtoByPage() {
        Page<UserDto> page = new Page<UserDto>().setSize(2).setCurrent(2);
        List<UserDto> userDtos = userDao.getUserDtoByPage(page);
        page.setRecords(userDtos);
        return page;
    }

    @GetMapping("userXml")
    public UserInfo getUserXml() {
        return userDao.getUserMapper();
    }

    /**
     * 多表分页查询
     * @return 分页数据
     */
//    @GetMapping("getUserInfoList")
//    public List<UserInfo> getUserInfoByPage() {
//        return userDao.getUserInfoList();
//    }

}
