package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.util.MarkUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_MARKS_REDIRECT;

@Controller
@RequiredArgsConstructor
public class CalculateController {
   private final MarkUtil markUtil;

    @GetMapping(value = "/calculate")
    public ModelAndView calculate(ModelAndView modelAndView) {
        markUtil.calculateIndividualStatistics(ProjectInfo.getCourse());
        markUtil.calculateTotalStatistics(ProjectInfo.getCourse());
        modelAndView.setViewName(PAGE_COACH_MARKS_REDIRECT);
        return modelAndView;
    }
}
