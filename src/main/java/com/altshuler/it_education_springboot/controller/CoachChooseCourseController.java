package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CoachService;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_CURRENT_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_SUCCESS_ENROLL;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Controller
@RequiredArgsConstructor
public class CoachChooseCourseController {

    private final CourseService courseService;
    private final CoachService coachService;

    @GetMapping(value = "/coachChooseCourse")
    public ModelAndView registerToCourse(@RequestParam(name = PARAM_NUMBER) Integer num,
                                         ModelAndView modelAndView) {
        Course course = courseService.getById(num);
        Coach coach = ProjectInfo.getCoach();
        coach.addCourse(course);
        course.setCoach(coach);
        coachService.add(coach);
        courseService.update(course);
        ProjectInfo.setCoach(coach);
        modelAndView.addObject(ATTR_CURRENT_COURSE, course);
        modelAndView.setViewName(PAGE_COACH_SUCCESS_ENROLL);
        return modelAndView;
    }
}
