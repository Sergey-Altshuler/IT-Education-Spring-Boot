package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.converters.ConverterProvider;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.service.CoachService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_SUCCESS_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;

@Controller
public class CoachRegisterController {
    @Autowired
    CoachService coachService;
    private final ParseUtil parseUtil = new ParseUtil();
    @RequestMapping(value = "/coachRegister", method = RequestMethod.POST)
    public ModelAndView registerCoach(ModelAndView modelAndView, HttpServletRequest request) {
        coachService.add(ConverterProvider.convert(Coach.class, request));
        modelAndView.addObject(PARAM_PASSWORD, parseUtil.encryptPassword(request.getParameter(PARAM_PASSWORD)));
        modelAndView.setViewName(PAGE_COACH_SUCCESS_REGISTER);
        return modelAndView;
    }
}
