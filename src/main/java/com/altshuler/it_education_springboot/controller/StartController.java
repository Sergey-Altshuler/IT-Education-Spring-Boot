package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_LANGUAGE;

@Controller
@RequiredArgsConstructor
public class StartController {

    private final AdminService adminService;

    @RequestMapping(value = "/chooseLanguage", method = RequestMethod.GET)
    public ModelAndView start(ModelAndView modelAndView) {
        adminService.initialize();
        modelAndView.setViewName(PAGE_CHOOSE_LANGUAGE);
        return modelAndView;
    }

}


