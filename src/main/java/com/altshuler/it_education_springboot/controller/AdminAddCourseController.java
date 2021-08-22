package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.converters.ConverterProvider;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_ADD;

@Controller
public class AdminAddCourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/adminAddCourse", method = RequestMethod.POST)
    public ModelAndView validateAdmin(ModelAndView modelAndView, HttpServletRequest request) {
        courseService.add(ConverterProvider.convert(Course.class, request));
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_SUCCESS_ADD);
        return modelAndView;
    }
}
