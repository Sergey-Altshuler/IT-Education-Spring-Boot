package com.altshuler.it_education_springboot.filters;


import com.altshuler.it_education_springboot.servlce.AdminService;
import com.altshuler.it_education_springboot.servlce.AdminServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_DATA;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;

@Component
public class AdminValidateFilter implements Filter {
    private final AdminService adminService = new AdminServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        if ((req.getRequestURL().toString().matches(".*/adminEnter.*"))) {
            if ((adminService.validate(req.getParameter(PARAM_LOGIN), req.getParameter(PARAM_PASSWORD))) &&
                    (req.getParameter(PARAM_PASSWORD)).equals(req.getParameter(PARAM_REPEATED)))
                filterChain.doFilter(req, resp);
            else resp.sendRedirect(contextPath + PAGE_WRONG_DATA);
        } else filterChain.doFilter(req, resp);
    }
}
