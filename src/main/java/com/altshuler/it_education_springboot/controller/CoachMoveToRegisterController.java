package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_REGISTER;

@Controller
public class CoachMoveToRegisterController {
    @RequestMapping(value = "/coachMoveToRegister", method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_COACH_REGISTER);
        return modelAndView;
    }
}
