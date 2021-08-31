package com.altshuler.it_education_springboot.service;

import com.altshuler.it_education_springboot.model.Course;
import org.springframework.http.ResponseEntity;

public interface CourseRestService {
    ResponseEntity<Course> save(Course course);


}
