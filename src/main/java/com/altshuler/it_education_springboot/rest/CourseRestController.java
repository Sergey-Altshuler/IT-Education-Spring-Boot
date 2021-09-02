package com.altshuler.it_education_springboot.rest;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseRestController {

    private final CourseRestService courseRestService;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return courseRestService.save(course);
    }
    @DeleteMapping
    public ResponseEntity<Boolean> deleteCourse(@RequestParam Integer id) {
        courseRestService.delete(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}
