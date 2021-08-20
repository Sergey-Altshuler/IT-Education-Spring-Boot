package com.altshuler.it_education_springboot.service;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student checkStudent(String login, String password) {
        List<Student>studentList =  studentRepository.getCoachWithCurrentData(login, password);
        if ((studentList == null) || (studentList.size() == 0)) {
            return null;
        } else return studentList.get(0);
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public boolean validate(String login, String password) {
        return checkStudent(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setStudent(checkStudent(login, password));
    }


}
