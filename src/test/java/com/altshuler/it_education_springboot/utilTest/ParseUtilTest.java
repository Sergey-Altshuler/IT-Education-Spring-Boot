package com.altshuler.it_education_springboot.utilTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ParseUtilTest {

    @Test
    void parseRightDate() {
        String stringDate = SUCCESS_DATE;
        Date date = Date.valueOf(LocalDate.parse(stringDate));
        assertEquals(date, ParseUtil.parseDate(stringDate));
    }

    @Test
    void parseWrongDate() {
        assertThrows(Exception.class, () -> ParseUtil.parseDate(FAIL_DATE));
    }

    @Test
    void parseStudent() {
        Student student = TestDataCreator.createTestStudentForParsing();
        assertEquals("student student", ParseUtil.parseStudent(student));
    }

    @Test
    void encryptPassword() {
        assertEquals("********", ParseUtil.encryptPassword(PASSWORD));
    }
}
