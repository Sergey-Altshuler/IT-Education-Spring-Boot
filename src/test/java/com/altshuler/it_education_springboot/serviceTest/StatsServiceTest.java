package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StatsServiceTest {
    @Autowired
    StatsService statsService;

    @BeforeEach
    void generateForTesting() {
        statsService.add(TestDataCreator.createTestGetAllStats());
        statsService.add(TestDataCreator.createTestAddStats());
    }

    @Test
    void getAll() {
        assertEquals(2, statsService.getAll().size());
    }

    @AfterEach
    void clearDatabase() {
        statsService.deleteAll();
    }
}
