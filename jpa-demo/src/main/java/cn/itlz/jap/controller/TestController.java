package cn.itlz.jap.controller;

import cn.itlz.jap.dto.response.CourseDto;
import cn.itlz.jap.dto.response.UserDto;
import cn.itlz.jap.entity.Course;
import cn.itlz.jap.entity.User;
import cn.itlz.jap.repository.jpa.CourseRepository;
import cn.itlz.jap.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("user")
    public String getUser() {
        User u = userRepository.getOne(1L);

        return u.getName();
    }

    @GetMapping("course")
    public List<CourseDto> getCourse() {
        List<Course> course = courseRepository.findAll();
//        User user = course.getUser();
        List<CourseDto> list = new ArrayList<>();
        course.forEach(course1 -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setUserName(course1.getUser().getName());
            courseDto.setName(course1.getName());
            list.add(courseDto);
        });
        return list;
    }

    @GetMapping("user1")
    public UserDto getUserDto() {
        User user = userRepository.getOne(1L);
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
//        userDto.setCourseName(user.get);
//        return userRepository.getUserDto();

        return null;
    }

    @GetMapping("saveUser")
    public String saveUser() {
        User user = new User();
        user.setAge(25);
        user.setName("hhh");

        userRepository.save(user);
        return "success";
    }

    @GetMapping("saveCourse")
    public String saveCourse() {
        Course course = new Course();
        course.setName("语文课程");
        courseRepository.save(course);
        return "course";
    }

    @GetMapping("join")
    public String joinUser() {
        Course course = courseRepository.getOne(1L);
        User user = userRepository.getOne(1L);
        Set<Course> courses = new HashSet<>();
        courses.add(course);
//        user.setCourses(courses);
        userRepository.save(user);
        return "join";
    }

    @GetMapping("users")
    public List<UserDto> getUserIdAndName() {
        return userRepository.getUsers();
    }


}
