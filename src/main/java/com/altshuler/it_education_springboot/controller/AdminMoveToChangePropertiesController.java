package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_CHANGE_PROPERTIES;

@Controller
public class AdminMoveToChangePropertiesController {
    @RequestMapping(value = "/adminMoveToChangeProperties", method = RequestMethod.GET)
    public ModelAndView adminMoveToChangeProperties(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADMIN_CHANGE_PROPERTIES);
        return modelAndView;
    }
}
