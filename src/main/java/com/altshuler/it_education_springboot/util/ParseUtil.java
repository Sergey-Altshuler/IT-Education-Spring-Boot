package com.altshuler.it_education_springboot.util;

import com.altshuler.it_education_springboot.model.Student;

import java.sql.Date;
import java.time.LocalDate;

public class ParseUtil {
    public static Date parseDate(String element) {
        LocalDate localDate = LocalDate.parse(element);
        return Date.valueOf(localDate);
    }

    public static String parseStudent(Student student) {
        return student.getName() + " " + student.getSurname();
    }

    public static String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            encrypted.append("*");
        }
        return encrypted.toString();
    }
}
