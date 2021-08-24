package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CourseServiceTest {
    @Autowired
    CourseService courseService;

    @BeforeEach
    void generateForTesting() {
        courseService.add(TestDataCreator.createTestGetByIdCourse());
        courseService.add(TestDataCreator.createTestGetAllCourse());
    }

    @Test
    void change() {
        courseService.add(TestDataCreator.createTestChangeCourse());
        assertEquals(3, courseService.getAll().size());
        courseService.deleteById(3);
        assertEquals(2, courseService.getAll().size());
    }

    @Test
    void getAll() {
        assertEquals(2, courseService.getAll().size());
    }

    @AfterEach
    void clearDatabase() {
        courseService.deleteAll();
    }
}
