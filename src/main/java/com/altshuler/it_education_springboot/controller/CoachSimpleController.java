package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.converter.ConverterProvider;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.service.CoachService;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_COACH;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.REQUEST_COACH_MOVE_TO_REGISTER;

@Controller
@RequiredArgsConstructor
public class CoachSimpleController {
    private final CourseService courseService;
    private final CoachService coachService;

    @GetMapping(value = "/coachEnter")
    public ModelAndView validateCoach(ModelAndView modelAndView) {
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_COACH_CHOOSE_COURSE);
        return modelAndView;
    }

    @PostMapping(value = "/coachRegister")
    public ModelAndView registerCoach(ModelAndView modelAndView, HttpServletRequest request) {
        coachService.add(ConverterProvider.convert(Coach.class, request));
        modelAndView.addObject(PARAM_PASSWORD, ParseUtil.encryptPassword(request.getParameter(PARAM_PASSWORD)));
        modelAndView.setViewName(PAGE_COACH_SUCCESS_REGISTER);
        return modelAndView;
    }

    @GetMapping(value = "/coachValidate")
    public ModelAndView startCoach(ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(PARAM_COACH);
        modelAndView.setViewName(path);
        return modelAndView;
    }
}
