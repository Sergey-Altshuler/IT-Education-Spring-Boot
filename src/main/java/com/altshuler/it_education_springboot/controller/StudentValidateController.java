package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_STUDENT;

@Controller
public class StudentValidateController {
    @RequestMapping(value = "/studentValidate", method = RequestMethod.GET)
    public ModelAndView startStudent(ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(PARAM_STUDENT);
        modelAndView.setViewName(path);
        return modelAndView;
    }
}
