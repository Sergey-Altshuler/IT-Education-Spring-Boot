package com.altshuler.it_education_springboot.TestInfo;

import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Course;
import com.altshuler.it_education_springboot.model.Stats;
import com.altshuler.it_education_springboot.model.Student;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;

public class TestDataCreator {
    public static Coach createTestCoach() {
        return Coach.builder().name(COACH_NAME).surname(COACH_SURNAME).login(LOGIN).password(PASSWORD).build();
    }

    public static Student createTestStudent() {
        return Student.builder().name(STUDENT_NAME).surname(STUDENT_SURNAME).login(LOGIN).password(PASSWORD).build();
    }

    public static Stats createTestAddStats() {
        return Stats.builder().avgMark(5d).attendance(100d).build();
    }

    public static Stats createTestGetAllStats() {
        return Stats.builder().avgMark(1d).attendance(100d).build();
    }

    public static Course createTestChangeCourse() {
        return Course.builder().title(COURSE_TITLE_TEST1).build();
    }

    public static Course createTestGetByIdCourse() {
        return Course.builder().title(COURSE_TITLE_TEST2).build();
    }

    public static Course createTestGetAllCourse() {
        return Course.builder().title(COURSE_TITLE_TEST3).build();
    }

    public static Student createTestStudentForParsing() {
        return Student.builder().id(1).name(STUDENT_NAME).surname(STUDENT_SURNAME).build();
    }

    public static Course createEmptyTestCourse() {
        return Course.builder().build();
    }

    public static Student createNewTestStudent() {
        return Student.builder().name(STUDENT_NEW_NAME).build();
    }

    public static Coach createNewTestCoach() {
        return Coach.builder().name(COACH_NEW_NAME).build();
    }

    public static Student createValidateTestStudent() {
        return Student.builder().login(VALIDATE_LOGIN).password(VALIDATE_PASSWORD).build();
    }

    public static Student createLoginTestStudent() {
        return Student.builder().login(ENTER_LOGIN).password(ENTER_PASSWORD).build();
    }

    public static Coach createValidateTestCoach() {
        return Coach.builder().login(VALIDATE_LOGIN).password(VALIDATE_PASSWORD).build();
    }

    public static Coach createLoginTestCoach() {
        return Coach.builder().login(ENTER_LOGIN).password(ENTER_PASSWORD).build();
    }
}
