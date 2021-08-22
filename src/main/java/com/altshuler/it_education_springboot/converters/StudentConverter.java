package com.altshuler.it_education_springboot.converters;

import com.altshuler.it_education_springboot.model.Student;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

public class StudentConverter implements Converter<Student> {
    public Student convert(HttpServletRequest request) {
        return Student.builder()
                .login(request.getParameter(PARAM_LOGIN))
                .age(Integer.parseInt(request.getParameter(PARAM_AGE)))
                .password(request.getParameter(PARAM_PASSWORD))
                .name(request.getParameter(PARAM_NAME))
                .surname(request.getParameter(PARAM_SURNAME))
                .interests(request.getParameter(PARAM_INTERESTS))
                .build();
    }
}
