package cn.itlz.jap.controller;

import cn.itlz.jap.dto.response.UserDto;
import cn.itlz.jap.entity.Course;
import cn.itlz.jap.entity.User;
import cn.itlz.jap.repository.jpa.CourseRepository;
import cn.itlz.jap.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

//        UserDto userDto = new UserDto();
//        userDto.setId(u.getId());
//        userDto.setName(u.getName());
//        Set<Course> courses = u.getCourses();
        Set<Course> courses = u.getCourses();
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            return iterator.next().getName();
        }
        return null;
    }

    @GetMapping("course")
    public String getCourse() {
        Course course = courseRepository.getOne(1L);
        User user = course.getUser();
        return user.getName();
    }

    @GetMapping("user1")
    public UserDto getUserDto() {
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


}
