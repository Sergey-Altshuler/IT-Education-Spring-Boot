package com.altshuler.it_education_springboot.servlce;



import com.altshuler.it_education_springboot.model.Course;

import java.util.List;

public interface CourseService {
    Course add(Course course);
    Course getById(int id);
    List<Course> getAll();
    void deleteById(int id);
    void deleteAll();
}
