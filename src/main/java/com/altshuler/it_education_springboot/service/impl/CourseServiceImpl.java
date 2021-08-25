package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.repo.CourseRepository;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Course getById(int id) {
        return courseRepository.getById(id);
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
}
