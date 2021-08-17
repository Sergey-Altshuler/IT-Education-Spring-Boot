package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_ROLE;


@Controller
public class ChooseRoleController {
    @RequestMapping(value = "/chooseRole", method = RequestMethod.POST)
    public ModelAndView chooseRole(@RequestParam(name = PARAM_ROLE) String role, ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(role);
        modelAndView.setViewName(path);
        return modelAndView;
    }
}


