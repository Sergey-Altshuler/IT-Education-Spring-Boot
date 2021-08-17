package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_REGISTER;

@Controller
public class StudentMoveToRegisterController {
    @RequestMapping(value = "/studentMoveToRegister", method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_STUDENT_REGISTER);
        return modelAndView;
    }
}
