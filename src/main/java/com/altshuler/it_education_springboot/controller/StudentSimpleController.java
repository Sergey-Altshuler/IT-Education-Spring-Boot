package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.converter.ConverterProvider;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.service.StudentService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_CHOOSE_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_SUCCESS_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_STUDENT;

@Controller
@RequiredArgsConstructor
public class StudentSimpleController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/studentEnter")
    public ModelAndView validateStudent(ModelAndView modelAndView) {
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_STUDENT_CHOOSE_COURSE);
        return modelAndView;
    }

    @PostMapping(value = "/studentRegister")
    public ModelAndView registerStudent(ModelAndView modelAndView, HttpServletRequest request) {
        Student student = ConverterProvider.convert(Student.class, request);
        if (student != null) {
            student.setPassword(passwordEncoder.encode(request.getParameter(PARAM_PASSWORD)));
        }
        studentService.add(student);
        modelAndView.addObject(PARAM_PASSWORD, ParseUtil.encryptPassword(request.getParameter(PARAM_PASSWORD)));
        modelAndView.setViewName(PAGE_STUDENT_SUCCESS_REGISTER);
        return modelAndView;
    }

    @GetMapping(value = "/studentValidate")
    public ModelAndView startStudent(ModelAndView modelAndView) {
        String path = ProjectInfo.getRoles().get(PARAM_STUDENT);
        modelAndView.setViewName(path);
        return modelAndView;
    }
}
