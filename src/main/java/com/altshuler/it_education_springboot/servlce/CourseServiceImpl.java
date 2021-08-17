package com.altshuler.it_education_springboot.servlce;


import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

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
