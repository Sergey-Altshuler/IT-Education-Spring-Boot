package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.service.CourseService;
import com.altshuler.it_education_springboot.util.ParseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_PUT_MARKS;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Controller
@RequiredArgsConstructor
public class CoachPutMarksController {
    private final CourseService courseService;
    private final String regex = "[0-9]+";

    @RequestMapping(value = "coachPutMarks", method = RequestMethod.GET)
    public ModelAndView putMarks(@RequestParam(name = PARAM_NUMBER, required = false) String number,
                                 ModelAndView modelAndView) {
        int courseNum;
        if (number == null) {
            courseNum = ProjectInfo.getNumOfCurrentCourse();
        } else {
            courseNum = Integer.parseInt(number);
            ProjectInfo.setNumOfCurrentCourse(courseNum);
        }
        Course course = courseService.getById(courseNum);
        ProjectInfo.setCourse(course);
        Student anyStudent = course.getStudents().stream().findAny().get();
        Course currentCourse = ProjectInfo.getMarks().keySet().stream().filter(found -> found.getId().equals(course.getId())).findAny().get();
        Map<Student, Map<String, String>> courseMap = ProjectInfo.getMarks().get(currentCourse);

        modelAndView.addObject(ATTR_COURSE_MAP, courseMap);
        Map<String, String> studentMap = new LinkedHashMap<>(courseMap.get(anyStudent));
        List<String> elements = new ArrayList<>(studentMap.keySet());
        for (String element : elements) {
            if (!element.matches(regex)) {
                studentMap.remove(element);
            }
        }
        modelAndView.addObject(ATTR_TITLES, studentMap);
        Map<Integer, String> studentAdditionalMap = new LinkedHashMap<>();
        for (Student student : course.getStudents()) {
            studentAdditionalMap.put(student.getId(), ParseUtil.parseStudent(student));
        }
        modelAndView.addObject(ATTR_STUDENT_MAP, studentAdditionalMap);
        modelAndView.addObject(ATTR_NUMBER, courseNum);
        modelAndView.setViewName(PAGE_COACH_PUT_MARKS);
        return modelAndView;
    }
}
