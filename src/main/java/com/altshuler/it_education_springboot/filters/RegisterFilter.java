package com.altshuler.it_education_springboot.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_DATA;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_REPEATED;

@Component
public class RegisterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getRequestURL().toString().matches(".*/studentRegister.*"))||
                (req.getRequestURL().toString().matches(".*/coachRegister.*"))) {
            if ((req.getParameter(PARAM_PASSWORD)).equals(req.getParameter(PARAM_REPEATED))) {
                filterChain.doFilter(req, resp);
            } else resp.sendRedirect(contextPath + PAGE_WRONG_DATA);
        } else filterChain.doFilter(req, resp);
    }
}
