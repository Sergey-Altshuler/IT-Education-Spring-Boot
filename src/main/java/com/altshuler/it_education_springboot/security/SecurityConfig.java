package com.altshuler.it_education_springboot.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.*;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(REQUEST_DEFAULT, REQUEST_WELCOME, REQUEST_CHOOSE_LANGUAGE, REQUEST_ACCESS_DENIED, REQUEST_WRONG_DATA, REQUEST_WRONG_OPERATION, REQUEST_CSS).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(REQUEST_LOGIN)
                .defaultSuccessUrl(REQUEST_CHOOSE_ROLE_PAGE)
                .usernameParameter(PARAM_USER_NAME)
                .passwordParameter(PARAM_USER_PASSWORD)
                .failureUrl(REQUEST_ACCESS_DENIED)
                .permitAll()
                .and()
                .logout().logoutUrl(REQUEST_LOGOUT).logoutSuccessUrl(REQUEST_WELCOME)
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withUsername(PARAM_USER_NAME)
                        .password(passwordEncoder().encode(PARAM_USER_PASSWORD))
                        .roles(PARAM_DEFAULT_ROLE)
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
