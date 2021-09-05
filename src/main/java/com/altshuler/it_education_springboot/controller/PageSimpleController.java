package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_ROLE;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.*;

@Controller
public class PageSimpleController {
    @PostMapping(value = "/chooseRole")
    public ModelAndView chooseRole(@RequestParam(name = PARAM_ROLE) String role, ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(role);
        modelAndView.setViewName(path);
        return modelAndView;
    }
}


