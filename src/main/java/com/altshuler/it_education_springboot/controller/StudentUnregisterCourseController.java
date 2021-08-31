package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_CHOOSE_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Controller
@RequiredArgsConstructor
public class StudentUnregisterCourseController {
    private final CourseService courseService;
    private final StudentService studentService;

    @GetMapping(value = "/studentUnregisterCourse")
    public ModelAndView unregisterToCourse(@RequestParam(name = PARAM_NUMBER) Integer num,
                                           ModelAndView modelAndView) {
        Course course = courseService.getById(num);
        Student student = ProjectInfo.getStudent();
        course.getStudents().remove(student);
        student.setCourse(null);
        courseService.update(course);
        studentService.add(student);
        ProjectInfo.setStudent(student);
        modelAndView.addObject(ATTR_COURSES, courseService.getAll());
        modelAndView.setViewName(PAGE_STUDENT_CHOOSE_COURSE);
        return modelAndView;
    }
}

