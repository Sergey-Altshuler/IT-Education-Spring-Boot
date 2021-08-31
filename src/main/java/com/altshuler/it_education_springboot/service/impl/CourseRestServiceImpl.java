package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.repo.CourseRepository;
import com.altshuler.it_education_springboot.service.CourseRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseRestServiceImpl implements CourseRestService {
    private final CourseRepository courseRepository;

    @Override
    public ResponseEntity<Course> save(Course course) {
        Course newCourse = courseRepository.save(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
}
