package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.feignClient.CourseFeignClient;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.repo.CourseRepository;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.NO;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseFeignClient courseFeignClient;

    public Course add(Course course) {
        return courseFeignClient.save(course);
    }

    public Course getById(int id) {
        return courseRepository.getById(id);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    public void deleteAll() {
        courseRepository.deleteAll();
    }

    @Override
    public Integer getNumOfCoursesWithCurrentTitle(String title) {
        return (courseRepository.getCoursesListWithCurrentTitle(title).stream()
                .mapToInt(Course::getSubgroupNum).max().orElse(0))+1;
    }
}
