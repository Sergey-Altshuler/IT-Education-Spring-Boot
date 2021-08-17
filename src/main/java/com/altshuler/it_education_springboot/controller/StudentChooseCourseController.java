package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.servlce.CourseService;
import com.altshuler.it_education_springboot.servlce.CourseServiceImpl;
import com.altshuler.it_education_springboot.servlce.StudentService;
import com.altshuler.it_education_springboot.servlce.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_CURRENT_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_SUCCESS_ENROLL;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Controller
public class StudentChooseCourseController  {
    private final CourseService courseService = new CourseServiceImpl();
    private final StudentService studentService = new StudentServiceImpl();
    @RequestMapping(value = "/studentChooseCourse", method = RequestMethod.GET)
    public ModelAndView registerToCourse(@RequestParam(name = PARAM_NUMBER) String login,
                                         ModelAndView modelAndView) {
        Course course = courseService.getById(Integer.parseInt(login));
        Student student = ProjectInfo.getStudent();
        course.addStudent(student);
        student.setCourse(course);
        courseService.add(course);
        studentService.add(student);
        ProjectInfo.setStudent(student);
        modelAndView.addObject(ATTR_CURRENT_COURSE, course);
        modelAndView.setViewName(PAGE_STUDENT_SUCCESS_ENROLL);
        return modelAndView;
    }
}
