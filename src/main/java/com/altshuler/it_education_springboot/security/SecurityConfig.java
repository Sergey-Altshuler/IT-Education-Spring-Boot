package com.altshuler.it_education_springboot.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WELCOME;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_NAME;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_USER_PASSWORD;
import static com.altshuler.it_education_springboot.info.ProjectRequestURLNames.*;


@Configuration
@EnableConfigurationProperties
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   /* private final DBUserDetailsService DBUserDetailsService;*/
   /* private final AuthSuccessHandler authSuccessHandler;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(REQUEST_DEFAULT, REQUEST_WELCOME, REQUEST_CHOOSE_LANGUAGE, REQUEST_ACCESS_DENIED, REQUEST_WRONG_DATA, REQUEST_WRONG_OPERATION, "/myStyles.css").permitAll()
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
               /* .formLogin()
                .loginPage(REQUEST_LOGIN)
                .loginProcessingUrl(REQUEST_LOGIN)
                .usernameParameter(PARAM_USER_NAME)
                .passwordParameter(PARAM_USER_PASSWORD)
                .defaultSuccessUrl(REQUEST_CHOOSE_ROLE_PAGE)
                .failureUrl(REQUEST_ACCESS_DENIED)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl(REQUEST_WELCOME);*/

    }

   /* http.authorizeRequests()
            .antMatchers("/","/list").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
            .antMatchers("/new-user", "/delete-user/*").access("hasRole('ADMIN')")
            .antMatchers("/edit-user/*").access("hasRole('ADMIN') or hasRole('USER')")
            .and()
            .formLogin()
                .loginPage("/login.jsp")
                .loginProcessingUrl("/login")
                .usernameParameter("ssoid")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("logout")
            .and()
            .rememberMe()
                .rememberMeParameter("remeber-me")
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(46800)
            .and().csrf()
            .and().exceptionHandling().accessDeniedPage("/access_denied");*/

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username(PARAM_USER_NAME)
                        .password(PARAM_USER_PASSWORD)
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
    /*@Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(DBUserDetailsService);
    }*/


}
