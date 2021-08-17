package com.altshuler.it_education_springboot.servlce;


import com.altshuler.it_education_springboot.model.Student;

import java.util.List;

public interface StudentService {
    Student add(Student student);
    Student getById(int id);
    boolean validate(String login, String password);
    void logIn(String login, String password);
    void deleteAll();
    List<Student> getCoachWithCurrentData(String login, String password);
}
