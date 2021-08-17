package com.altshuler.it_education_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;

@Controller
public class ChooseRolePageController {
    @RequestMapping (value = "/chooseRolePage", method = RequestMethod.GET)
    public ModelAndView goToChooseRolePage( ModelAndView modelAndView){
        modelAndView.setViewName(PAGE_CHOOSE_ROLE);
        return modelAndView;
    }
}
