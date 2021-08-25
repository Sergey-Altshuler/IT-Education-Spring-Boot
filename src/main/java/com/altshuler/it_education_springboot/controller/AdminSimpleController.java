package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_ADMIN;

@Controller
public class AdminSimpleController {
    @PostMapping(value = "/adminEnter")
    public ModelAndView validateAdmin(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADMIN_ACTIONS);
        return modelAndView;
    }

    @GetMapping(value = "/adminActions")
    public ModelAndView moveToAdminActions(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADMIN_ACTIONS);
        return modelAndView;
    }

    @GetMapping(value = "/adminMoveToAddCourse")
    public ModelAndView welcome(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADD_COURSE);
        return modelAndView;
    }

    @GetMapping(value = "/adminMoveToChangeProperties")
    public ModelAndView adminMoveToChangeProperties(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_ADMIN_CHANGE_PROPERTIES);
        return modelAndView;
    }

    @GetMapping(value = "/adminValidate")
    public ModelAndView startAdmin(ModelAndView modelAndView) {
        modelAndView.setViewName(ProjectInfo.getRoles().get(PARAM_ADMIN));
        return modelAndView;
    }

}

