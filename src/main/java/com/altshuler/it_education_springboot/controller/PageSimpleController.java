package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_ROLE;

@Controller
public class PageSimpleController {
    @PostMapping(value = "/chooseRole")
    public ModelAndView chooseRole(@RequestParam(name = PARAM_ROLE) String role, ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(role);
        modelAndView.setViewName(path);
        return modelAndView;
    }
    @GetMapping(value = "/chooseRolePage")
    public ModelAndView goToChooseRolePage(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_CHOOSE_ROLE);
        return modelAndView;
    }
    @GetMapping(value = "/wrongOperation")
    public ModelAndView wrongOperation(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_WRONG_OPERATION);
        return modelAndView;
    }
    @GetMapping(value = "/wrongData")
    public ModelAndView wrongData(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_WRONG_DATA);
        return modelAndView;
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView modelAndView) {
        modelAndView.setViewName(PAGE_WELCOME);
        return modelAndView;
    }
}


