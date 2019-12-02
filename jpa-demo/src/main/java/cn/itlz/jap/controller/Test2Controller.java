package cn.itlz.jap.controller;

import cn.itlz.jap.dto.response.CourseDto;
import cn.itlz.jap.entity.CourseEntity;
import cn.itlz.jap.entity.UserEntity;
import cn.itlz.jap.repository.jpa.CourseEntityRepository;
import cn.itlz.jap.repository.jpa.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Liuzd QQ: 77822013 2019/5/13 0013
 */
@RestController
public class Test2Controller {

    @Autowired
    private CourseEntityRepository courseEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @GetMapping("getCourses")
    public List<CourseDto> getCourseList() {
        List<CourseDto> courseDtos = new ArrayList<>();

        Set<Long> userIds = new HashSet<>();


        long start = System.currentTimeMillis();

        List<CourseEntity> courseEntities = courseEntityRepository.findAll();

        courseEntities.forEach(courseEntity -> {
            userIds.add(courseEntity.getUserId());
        });


        List<UserEntity> userEntities = userEntityRepository.findByIdIn(userIds);
        long end = System.currentTimeMillis();
        System.out.println(end - start);


        Map<Long, UserEntity> userEntityMap = new HashMap<>();
        userEntities.forEach(userEntity -> {
            userEntityMap.put(userEntity.getId(), userEntity);
        });

        courseEntities.forEach(courseEntity -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setName(courseEntity.getName());
            courseDto.setUserName(userEntityMap.get(courseEntity.getUserId()).getName());
            courseDtos.add(courseDto);
        });

        return courseDtos;
    }

    @GetMapping("getCourses2")
    public List<CourseDto> getCourseList2() {
        long start = System.currentTimeMillis();
        List<CourseDto> list = courseEntityRepository.getCourseDtos();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        return list;
    }
}
