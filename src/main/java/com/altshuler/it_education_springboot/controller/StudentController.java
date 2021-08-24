package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_CHOOSE_COURSE;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final CourseService courseService;

    @RequestMapping(value = "/studentEnter", method = RequestMethod.GET)
    public ModelAndView validateStudent(ModelAndView modelAndView) {
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_STUDENT_CHOOSE_COURSE);
        return modelAndView;
    }
}
