package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_STATS;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_STATS;

@Controller
public class AdminDisplayStatsController {
    @Autowired
    StatsService statsService;

    @RequestMapping(value = "/adminDisplayStats", method = RequestMethod.GET)
    public ModelAndView displayStatsList(ModelAndView modelAndView) {
        modelAndView.addObject(ATTR_STATS, statsService.getAll());
        modelAndView.setViewName(PAGE_ADMIN_DISPLAY_STATS);
        return modelAndView;
    }
}

