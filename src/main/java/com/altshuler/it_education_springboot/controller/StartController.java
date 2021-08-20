package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_LANGUAGE;


@Controller
public class StartController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/chooseLanguage", method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView) {
        adminService.initialize();
        modelAndView.setViewName(PAGE_CHOOSE_LANGUAGE);
        return modelAndView;
    }

}


