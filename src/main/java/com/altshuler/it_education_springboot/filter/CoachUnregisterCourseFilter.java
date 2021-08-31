package com.altshuler.it_education_springboot.filter;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.NO;
import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.YES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_OPERATION;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_NUMBER;

@Component
@RequiredArgsConstructor
public class CoachUnregisterCourseFilter implements Filter {
    private final CourseService courseService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getRequestURL().toString().matches(".*/coachUnregisterCourse.*"))) {
            Course course = courseService.getById(Integer.parseInt(req.getParameter(PARAM_NUMBER)));
            if (((NO).equals(course.getIsStarted())) && (course.getCoach() != null) && (ProjectInfo.getCoach() != null) && (course.getCoach().equals(ProjectInfo.getCoach()))) {
                course.setCoachRequired(YES);
                courseService.update(course);
                filterChain.doFilter(req, resp);
            } else {
                resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);
            }
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}
