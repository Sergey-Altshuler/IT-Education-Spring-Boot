package com.altshuler.it_education_springboot.rest;

import com.altshuler.it_education_springboot.converter.ConverterProvider;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseRestService;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_ADD;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_OPERATION;

@RestController
@RequestMapping("/adminAddCourse")
@RequiredArgsConstructor
public class CourseRestController {

    private final CourseRestService courseRestService;
    private final CourseService courseService;

    @PostMapping
    public ModelAndView saveCourse(HttpServletRequest httpRequest, ModelAndView modelAndView) {
        Course course = ConverterProvider.convert(Course.class, httpRequest);
        ResponseEntity<Course> responseEntity = courseRestService.save(course);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            modelAndView.addObject(ATTR_COURSES, courseService.getAll());
            modelAndView.setViewName(PAGE_ADMIN_SUCCESS_ADD);
        } else modelAndView.setViewName(PAGE_WRONG_OPERATION);
        return modelAndView;

    }
}
