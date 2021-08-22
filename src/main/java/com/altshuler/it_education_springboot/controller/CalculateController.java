package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.util.MarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_MARKS_REDIRECT;

@Controller
public class CalculateController {
    @Autowired
    MarkUtil markUtil;

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ModelAndView calculate(ModelAndView modelAndView) {
        markUtil.calculateIndividualStatistics(ProjectInfo.getCourse());
        markUtil.calculateTotalStatistics(ProjectInfo.getCourse());
        modelAndView.setViewName(PAGE_COACH_MARKS_REDIRECT);
        return modelAndView;
    }
}
