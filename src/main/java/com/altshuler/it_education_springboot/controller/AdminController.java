package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_ACTIONS;


@Controller
public class AdminController {
    @RequestMapping(value = "/adminEnter", method = RequestMethod.POST)
    public ModelAndView validateAdmin(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADMIN_ACTIONS);
        return modelAndView;
    }
}

