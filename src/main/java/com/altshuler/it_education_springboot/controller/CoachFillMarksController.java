package com.altshuler.it_education_springboot.controller;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.util.MarkUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_MARKS_REDIRECT;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUM_OF_CURRENT_LESSON;
@Controller
@RequiredArgsConstructor
public class CoachFillMarksController {

    private final MarkUtil markUtil;

    @PostMapping(value = "coachFillMarks")
    public ModelAndView putMarks(ModelAndView modelAndView, HttpServletRequest request) {
        int numLesson = Integer.parseInt(request.getParameter(PARAM_NUM_OF_CURRENT_LESSON));
        Enumeration<String> params = request.getParameterNames();
        Map<String, String> studentsAndMarks = new HashMap<>();
        while (params.hasMoreElements()) {
            String param = params.nextElement();
            if (!PARAM_NUM_OF_CURRENT_LESSON.equals(param))
                studentsAndMarks.put(param, request.getParameter(param));
        }
        markUtil.setLessonMarks(ProjectInfo.getCourse(), studentsAndMarks, numLesson);
        modelAndView.setViewName(PAGE_COACH_MARKS_REDIRECT);
        return modelAndView;
    }
}


