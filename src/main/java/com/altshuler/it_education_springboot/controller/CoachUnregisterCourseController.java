package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CoachService;
import com.altshuler.it_education_springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_CHOOSE_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Controller
public class CoachUnregisterCourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    CoachService coachService;

    @RequestMapping(value = "/coachUnregisterCourse", method = RequestMethod.GET)
    public ModelAndView registerToCourse(@RequestParam(name = PARAM_NUMBER) String login,
                                         ModelAndView modelAndView) {
        Course course = courseService.getById(Integer.parseInt(login));
        Coach coach = ProjectInfo.getCoach();
        course.setCoach(null);
        coach.getCourseSet().remove(course);
        coachService.add(coach);
        courseService.add(course);
        ProjectInfo.setCoach(coach);
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_COACH_CHOOSE_COURSE);
        return modelAndView;
    }
}

