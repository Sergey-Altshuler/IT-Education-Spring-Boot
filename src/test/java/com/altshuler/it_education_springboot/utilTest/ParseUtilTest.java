package com.altshuler.it_education_springboot.utilTest;

import com.altshuler.it_education_springboot.TestInfo.TestDataCreator;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParseUtilTest {
    ParseUtil parseUtil = new ParseUtil();

    @Test
    void parseRightDate() {
        String stringDate = SUCCESS_DATE;
        Date date = Date.valueOf(LocalDate.parse(stringDate));
        assertEquals(date, parseUtil.parseDate(stringDate));
    }

    @Test
    void parseWrongDate() {
        assertThrows(Exception.class, () -> parseUtil.parseDate(FAIL_DATE));
    }

    @Test
    void parseStudent() {
        Student student = TestDataCreator.createTestStudentForParsing();
        assertEquals("student student", parseUtil.parseStudent(student));
    }

    @Test
    void encryptPassword() {
        assertEquals("********", parseUtil.encryptPassword(PASSWORD));
    }
}
