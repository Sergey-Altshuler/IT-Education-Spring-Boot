package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.converter.ConverterProvider;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.AdminService;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_ADD;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

@Controller
@RequiredArgsConstructor
public class AdminManipulateDataController {

    private final AdminService adminService;
    private final CourseService courseService;

    @PostMapping(value = "/adminChangeProperties")
    public ModelAndView changeProperties(@RequestParam(name = PARAM_LOGIN) String login,
                                         @RequestParam(name = PARAM_CHANGED) String newPassword,
                                         ModelAndView modelAndView) {
        adminService.changeProperties(login, newPassword);
        modelAndView.addObject(PARAM_PASSWORD, ParseUtil.encryptPassword(newPassword));
        modelAndView.setViewName(PAGE_ADMIN_SUCCESS_CHANGE);
        return modelAndView;
    }

    @PostMapping(value = "/adminAddCourse")
    public ModelAndView saveCourse(HttpServletRequest httpRequest, ModelAndView modelAndView) {
        Course course = (ConverterProvider.convert(Course.class, httpRequest));
        if (course != null) {
            course.setSubgroupNum(courseService.getNumOfCoursesWithCurrentTitle(course.getTitle()));
        }
        courseService.add(course);
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_SUCCESS_ADD);
        return modelAndView;

    }
}
