package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.repo.CourseRepository;
import com.altshuler.it_education_springboot.service.CourseService;
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
    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    void generateForTesting() {
        courseService.saveOrUpdate(TestDataCreator.createTestGetByIdCourse());
        courseService.saveOrUpdate(TestDataCreator.createTestGetAllCourse());
    }

    @Test
    void change() {
        courseService.saveOrUpdate(TestDataCreator.createTestChangeCourse());
        assertEquals(3, courseService.getAll().size());
        courseRepository.deleteById(3);
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
