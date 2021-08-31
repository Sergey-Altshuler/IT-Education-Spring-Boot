package com.altshuler.it_education_springboot.service;

import com.altshuler.it_education_springboot.model.Course;

import java.util.List;

public interface CourseService {
    Course add(Course course);

    Course getById(int id);
    Course update(Course course);

    List<Course> getAll();

    void deleteById(int id);

    void deleteAll();
}
