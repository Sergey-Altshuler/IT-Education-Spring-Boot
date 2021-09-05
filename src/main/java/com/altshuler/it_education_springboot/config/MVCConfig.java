package com.altshuler.it_education_springboot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.*;

@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
    }

    @Override
    public void addViewControllers(@NonNull ViewControllerRegistry registry) {
        registry.addViewController(REQUEST_ADMIN_ACTIONS).setViewName(PAGE_ADMIN_ACTIONS);
        registry.addViewController(REQUEST_ADMIN_MOVE_TO_ADD_COURSE).setViewName(PAGE_ADD_COURSE);
        registry.addViewController(REQUEST_ADMIN_MOVE_TO_CHANGE_PROPERTIES).setViewName(PAGE_ADMIN_CHANGE_PROPERTIES);
        registry.addViewController(REQUEST_COACH_MOVE_TO_REGISTER).setViewName(PAGE_COACH_REGISTER);
        registry.addViewController(REQUEST_CHOOSE_ROLE_PAGE).setViewName(PAGE_CHOOSE_ROLE);
        registry.addViewController(REQUEST_WRONG_OPERATION).setViewName(PAGE_WRONG_OPERATION);
        registry.addViewController(REQUEST_WELCOME).setViewName(PAGE_WELCOME);
        registry.addViewController(REQUEST_WRONG_DATA).setViewName(PAGE_WRONG_DATA);
        registry.addViewController(REQUEST_STUDENT_MOVE_TO_REGISTER).setViewName(PAGE_STUDENT_REGISTER);
        registry.addViewController(REQUEST_ACCESS_DENIED).setViewName(PAGE_ACCESS_DENIED);
        registry.addViewController(REQUEST_LOGIN).setViewName(PAGE_USER_LOGIN);
    }

}
