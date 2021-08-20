package com.altshuler.it_education_springboot.controller;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.util.MarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_MARKS_REDIRECT;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUM_OF_CURRENT_LESSON;
@Controller
public class CoachFillMarksController {

    @Autowired
    MarkUtil markUtil;

    @RequestMapping(value = "coachFillMarks", method = RequestMethod.POST)
    public ModelAndView putMarks(ModelAndView modelAndView, HttpServletRequest request) {
        int numLesson = Integer.parseInt(request.getParameter(PARAM_NUM_OF_CURRENT_LESSON));
        Enumeration<String> params = request.getParameterNames();
        Map<String, String> studentsAndMarks = new HashMap<>();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            if (!param.equals(PARAM_NUM_OF_CURRENT_LESSON))
                studentsAndMarks.put(param, request.getParameter(param));
        }
        markUtil.setLessonMarks(ProjectInfo.getCourse(), studentsAndMarks, numLesson);
        modelAndView.setViewName(PAGE_COACH_MARKS_REDIRECT);
        return modelAndView;
    }
}


