package com.altshuler.it_education_springboot.service;

import com.altshuler.it_education_springboot.model.Student;

public interface StudentService {
    Student add(Student student);

    Student getById(int id);

    boolean validate(String login, String password);

    void logIn(String login, String password);

    void deleteAll();

    Student checkStudent(String login, String password);
}
