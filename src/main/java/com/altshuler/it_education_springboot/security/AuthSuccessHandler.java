package com.altshuler.it_education_springboot.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.REQUEST_CHOOSE_ROLE_PAGE;

/*@Component*/
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /*@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
            getRedirectStrategy().sendRedirect(request, response, REQUEST_CHOOSE_ROLE_PAGE);
    }*/
}
