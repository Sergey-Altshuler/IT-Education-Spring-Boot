package com.altshuler.it_education_springboot.converter;

import com.altshuler.it_education_springboot.model.Coach;
import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

public class CoachConverter implements Converter<Coach> {
    public Coach convert(HttpServletRequest request) {
        return Coach.builder()
                .login(request.getParameter(PARAM_LOGIN))
                .age(Integer.parseInt(request.getParameter(PARAM_AGE)))
                .name(request.getParameter(PARAM_NAME))
                .surname(request.getParameter(PARAM_SURNAME))
                .build();
    }
}
