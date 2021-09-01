package com.altshuler.it_education_springboot.converter;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.util.ParseUtil;

import javax.servlet.http.HttpServletRequest;

import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.NO;
import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.YES;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
public class CourseConverter implements Converter<Course> {

    public Course convert(HttpServletRequest request) {
        return Course.builder()
                .title(request.getParameter(PARAM_TITLE))
                .educationType(request.getParameter(PARAM_EDUCATION_TYPE))
                .price(Integer.parseInt(request.getParameter(PARAM_PRICE)))
                .numOfLessons(Integer.parseInt(request.getParameter(PARAM_NUM_OF_LESSONS)))
                .address(request.getParameter(PARAM_ADDRESS))
                .numOfStudents(Integer.parseInt(request.getParameter(PARAM_NUM_OF_STUDENTS)))
                .startDate(ParseUtil.parseDate(request.getParameter(PARAM_START_DATE)))
                .finishDate(ParseUtil.parseDate(request.getParameter(PARAM_FINISH_DATE)))
                .isStarted(NO)
                .isFinished(NO)
                .coachRequired(YES)
                .remaining(Integer.parseInt(request.getParameter(PARAM_NUM_OF_STUDENTS))).build();
    }
}
