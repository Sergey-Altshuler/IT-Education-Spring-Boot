package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WELCOME;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_WELCOME);
        return modelAndView;
    }
}

