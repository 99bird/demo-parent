package cn.itlz.jap.controller;

import cn.itlz.jap.dto.response.UserDto;
import cn.itlz.jap.entity.Course;
import cn.itlz.jap.entity.User;
import cn.itlz.jap.repository.jpa.CourseRepository;
import cn.itlz.jap.repository.jpa.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Liuzd QQ: 77822013 2019/4/4 0004
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    /*@GetMapping("user")
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
    }*/

    /*@GetMapping("course")
    public String getCourse() {
        Course course = courseRepository.getOne(1L);
        User user = course.getUser();
        return user.getName();
    }
*/
    @GetMapping("user1")
    public UserDto getUserDto() {
//        return userRepository.getUserDto();
        return null;
    }

    @GetMapping("saveUser")
    public String saveUser() {

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("李"+i);
            List<Course> courseList = new ArrayList<>();
            for (int j = 0; j < 500; j++) {
                Course course = new Course();
                course.setName("课程-李-"+i);
                courseList.add(course);
            }
            user.setCourses(courseList);
            list.add(user);
        }

        log.info("初始化数据成功！");

        userRepository.saveAll(list);
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
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }




}
