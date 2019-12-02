package cn.itlz.demo.webflux.controller;

import cn.itlz.demo.webflux.dto.request.UserParamDto;
import cn.itlz.demo.webflux.entity.Course;
import cn.itlz.demo.webflux.entity.User;
import cn.itlz.demo.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * @author Liuzd QQ: 77822013 2019/4/20 0020
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public Mono<User> addUser(@RequestBody UserParamDto paramDto) {
        User user = new User();
        user.setAge(paramDto.getAge());
        user.setEmail(paramDto.getEmail());
        user.setUserName(paramDto.getUserName());

        Course course = new Course();
        course.setCourseName("语文");

        List<Course> list = Collections.singletonList(course);
        user.setCourses(list);
        return userService.save(user);
    }

    @GetMapping(value = "getAllUser")
    public Flux<User> getAllUser() {
        return userService.findAll();
    }
}
