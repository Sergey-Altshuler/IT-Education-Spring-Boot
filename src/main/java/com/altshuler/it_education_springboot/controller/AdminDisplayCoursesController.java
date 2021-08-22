package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.util.MarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.YES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_DELETE_ID;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LAUNCH_ID;

@Controller
public class AdminDisplayCoursesController {
    @Autowired
    CourseService courseService;

    @Autowired
    MarkUtil markUtil;

    @RequestMapping(value = "/adminDisplayCourses", method = RequestMethod.GET)
    public ModelAndView displayCoursesList(
            @RequestParam(name = PARAM_LAUNCH_ID, required = false) String launchId,
            @RequestParam(name = PARAM_DELETE_ID, required = false) String deleteId,
            ModelAndView modelAndView) {
        if (launchId != null) {
            Course course = courseService.getById(Integer.parseInt(launchId));
            course.setIsStarted(YES);
            courseService.add(course);
            markUtil.initializeMarks(course);
        }
        if (deleteId != null) {
            courseService.deleteById(Integer.parseInt(deleteId));
        }
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_DISPLAY_COURSES);
        return modelAndView;
    }
}



