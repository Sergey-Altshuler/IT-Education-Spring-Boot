package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.service.StatsService;
import com.altshuler.it_education_springboot.util.MarkUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_STATS;
import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.YES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_STATS;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_DELETE_ID;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LAUNCH_ID;

@Controller
@RequiredArgsConstructor
public class AdminDisplayController {

    private final StatsService statsService;
    private final CourseService courseService;
    private final MarkUtil markUtil;

    @GetMapping(value = "/adminDisplayStats")
    public ModelAndView displayStatsList(ModelAndView modelAndView) {
        modelAndView.addObject(ATTR_STATS, statsService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_DISPLAY_STATS);
        return modelAndView;
    }

    @GetMapping(value = "/adminDisplayCourses")
    public ModelAndView displayCoursesList(
            @RequestParam(name = PARAM_LAUNCH_ID, required = false) String launchId,
            @RequestParam(name = PARAM_DELETE_ID, required = false) String deleteId,
            ModelAndView modelAndView) {
        if (StringUtils.isNotBlank(launchId)) {
            Course course = courseService.getById(Integer.parseInt(launchId));
            course.setIsStarted(YES);
            courseService.update(course);
            markUtil.initializeMarks(course);
        }
        if (StringUtils.isNotBlank(deleteId)) {
            courseService.deleteById(Integer.parseInt(deleteId));
        }
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_DISPLAY_COURSES);
        return modelAndView;
    }
}

