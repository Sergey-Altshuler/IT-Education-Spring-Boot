package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.service.AdminService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

@Controller
@RequiredArgsConstructor
public class AdminManipulateDataController {

    private final AdminService adminService;

    @PostMapping(value = "/adminChangeProperties")
    public ModelAndView changeProperties(@RequestParam(name = PARAM_LOGIN) String login,
                                         @RequestParam(name = PARAM_CHANGED) String newPassword,
                                         ModelAndView modelAndView) {
        adminService.changeProperties(login, newPassword);
        modelAndView.addObject(PARAM_PASSWORD, ParseUtil.encryptPassword(newPassword));
        modelAndView.setViewName(PAGE_ADMIN_SUCCESS_CHANGE);
        return modelAndView;
    }
}
