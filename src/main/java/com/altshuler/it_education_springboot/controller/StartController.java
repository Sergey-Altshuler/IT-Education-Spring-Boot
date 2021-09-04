package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.model.AppUser;
import com.altshuler.it_education_springboot.service.AdminService;
import com.altshuler.it_education_springboot.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_LANGUAGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_NAME;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_PASSWORD;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.REQUEST_CHOOSE_LANGUAGE;

@Controller
@RequiredArgsConstructor
public class StartController {

    private final AdminService adminService;
    private final AppUserService appUserService;

    @GetMapping(value = REQUEST_CHOOSE_LANGUAGE)
    public ModelAndView start(ModelAndView modelAndView) {
        adminService.initialize();
        if (!appUserService.isSaved()) {
            appUserService.add(AppUser.builder().username(PARAM_USER_NAME).password(PARAM_USER_PASSWORD).build());
        }
        modelAndView.setViewName(PAGE_CHOOSE_LANGUAGE);
        return modelAndView;
    }

}


