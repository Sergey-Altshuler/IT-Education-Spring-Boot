package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_LANGUAGE;

@Controller
@RequiredArgsConstructor
public class StartController {

    private final AdminService adminService;

    @GetMapping(value = "/chooseLanguage")
    public ModelAndView start(ModelAndView modelAndView) {
        adminService.initialize();
        modelAndView.setViewName(PAGE_CHOOSE_LANGUAGE);
        return modelAndView;
    }

}


