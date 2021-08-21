package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @BeforeEach
    void generateForTesting() {
        studentService.add(TestDataCreator.createValidateTestStudent());
        studentService.add(TestDataCreator.createLoginTestStudent());
    }

    @Test
    void add() {
        studentService.add(TestDataCreator.createNewTestStudent());
        assertNotNull(studentService.getById(3));
    }

    @Test
    void validate() {
        assertTrue(studentService.validate(VALIDATE_LOGIN, VALIDATE_PASSWORD));
    }

    @Test
    void logIn() {
        studentService.logIn(ENTER_LOGIN, ENTER_PASSWORD);
        assertEquals(ProjectInfo.getStudent().getPassword(), ENTER_PASSWORD);
    }

    @Test
    void getById() {
        studentService.add(TestDataCreator.createValidateTestStudent());
        Student detached = studentService.getById(3);
        System.out.println(detached.getLogin());
        System.out.println(detached.getId());
        assertEquals(VALIDATE_LOGIN, detached.getLogin());

    }

    @AfterEach
    void cleanDatabase() {
        studentService.deleteAll();
    }
}
