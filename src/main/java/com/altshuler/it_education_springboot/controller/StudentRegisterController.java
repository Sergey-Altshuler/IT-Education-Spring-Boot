package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.converters.ConverterProvider;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.servlce.CourseService;
import com.altshuler.it_education_springboot.servlce.StudentService;
import com.altshuler.it_education_springboot.servlce.StudentServiceImpl;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_SUCCESS_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;

@Controller
public class StudentRegisterController {
    @Autowired
    StudentService studentService;
    private final ParseUtil parseUtil = new ParseUtil();
    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public ModelAndView registerStudent(ModelAndView modelAndView, HttpServletRequest request){
        studentService.add(ConverterProvider.convert(Student.class, request));
        modelAndView.addObject(PARAM_PASSWORD, parseUtil.encryptPassword(request.getParameter(PARAM_PASSWORD)));
        modelAndView.setViewName(PAGE_STUDENT_SUCCESS_REGISTER);
        return modelAndView;
    }
}

