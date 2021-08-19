package com.altshuler.it_education_springboot.filters;

import com.altshuler.it_education_springboot.servlce.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_DATA;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

@Component
public class AdminChangePropertiesFilter implements Filter {
     @Autowired
     AdminService adminService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getRequestURL().toString().matches(".*/adminChangeProperties.*"))) {
            if (((req.getParameter(PARAM_CHANGED)).equals(req.getParameter(PARAM_REPEATED))) &&
                    (adminService.validate(req.getParameter(PARAM_LOGIN), req.getParameter(PARAM_PASSWORD))))
                filterChain.doFilter(req, resp);
            else resp.sendRedirect(contextPath + PAGE_WRONG_DATA);
        } else filterChain.doFilter(req, resp);
    }
}
