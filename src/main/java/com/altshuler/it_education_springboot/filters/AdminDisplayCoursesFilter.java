package com.altshuler.it_education_springboot.filters;

import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.service.CourseService;
import com.mysql.cj.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.NO;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_OPERATION;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_DELETE_ID;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LAUNCH_ID;

@Component
@RequiredArgsConstructor
public class AdminDisplayCoursesFilter implements Filter {
    private final CourseService courseService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getRequestURL().toString().matches(".*/adminDisplayCourses.*"))) {

            if (StringUtils.isNullOrEmpty(req.getParameter(PARAM_LAUNCH_ID)) && (StringUtils.isNullOrEmpty(req.getParameter(PARAM_DELETE_ID)))) {
                filterChain.doFilter(req, resp);
            } else {
                if (!StringUtils.isNullOrEmpty(req.getParameter(PARAM_LAUNCH_ID))) {
                    Course course = courseService.getById(Integer.parseInt(req.getParameter(PARAM_LAUNCH_ID)));
                    if ((!StringUtils.isNullOrEmpty(course.getCoachRequired())) && ((course.getRemaining() == 0) && (course.getCoachRequired().equals(NO)))) {
                        filterChain.doFilter(req, resp);
                    } else {
                        resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);
                    }
                }
                if (!StringUtils.isNullOrEmpty(req.getParameter(PARAM_DELETE_ID))) {
                    Course course = courseService.getById(Integer.parseInt(req.getParameter(PARAM_DELETE_ID)));
                    if (((course.getStudents() == null) || (course.getStudents().size() == 0)) && (course.getCoach() == null)) {
                        filterChain.doFilter(req, resp);
                    } else {
                        resp.sendRedirect(contextPath + PAGE_WRONG_OPERATION);
                    }
                }
            }
        } else {
            filterChain.doFilter(req, resp);
        }
    }
}

