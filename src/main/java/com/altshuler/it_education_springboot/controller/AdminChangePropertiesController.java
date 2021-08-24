package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.AdminService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

@Controller
@RequiredArgsConstructor
public class AdminChangePropertiesController {

    private final AdminService adminService;

    @RequestMapping(value = "/adminChangeProperties", method = RequestMethod.POST)
    public ModelAndView changeProperties(@RequestParam(name = PARAM_LOGIN) String login,
                                         @RequestParam(name = PARAM_CHANGED) String newPassword,
                                         ModelAndView modelAndView) {
        adminService.changeProperties(login, newPassword);
        modelAndView.addObject(PARAM_PASSWORD, ParseUtil.encryptPassword(newPassword));
        modelAndView.setViewName(PAGE_ADMIN_SUCCESS_CHANGE);
        return modelAndView;
    }
}

