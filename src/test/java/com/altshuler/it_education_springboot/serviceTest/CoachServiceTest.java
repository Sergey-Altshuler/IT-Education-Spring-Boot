package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.service.CoachService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CoachServiceTest {
    @Autowired
    CoachService coachService;

    @BeforeEach
    void generateForTesting() {
        coachService.add(TestDataCreator.createValidateTestCoach());
        coachService.add(TestDataCreator.createLoginTestCoach());
    }

    @Test
    void add() {
        coachService.add(TestDataCreator.createNewTestCoach());
        assertNotNull(coachService.getById(3));
    }

    @AfterEach
    void cleanDatabase() {
        coachService.deleteAll();
    }
}
