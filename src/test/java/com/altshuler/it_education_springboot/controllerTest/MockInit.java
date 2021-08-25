package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.repo.*;
import com.altshuler.it_education_springboot.service.*;
import com.altshuler.it_education_springboot.util.MarkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManagerFactory;

@WebMvcTest
public class MockInit {
    @Autowired
    protected MockMvc mockMvc;
    @MockBean
    protected EntityManagerFactory entityManagerFactory;
    @MockBean
    AdminRepository adminRepository;
    @MockBean
    CoachRepository coachRepository;
    @MockBean
    CourseRepository courseRepository;
    @MockBean
    StatsRepository statsRepository;
    @MockBean
    StudentRepository studentRepository;
    @MockBean
    AdminService adminService;
    @MockBean
    CoachService coachService;
    @MockBean
    CourseService courseService;
    @MockBean
    StatsService statsService;
    @MockBean
    StudentService studentService;
    @MockBean
    MarkUtil markUtil;
    @MockBean
    CourseRestService courseRestService;

}
