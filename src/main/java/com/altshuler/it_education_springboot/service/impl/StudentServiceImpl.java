package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.repo.StudentRepository;
import com.altshuler.it_education_springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student checkStudent(String login, String password) {
        List<Student> studentList = studentRepository.getCoachWithCurrentData(login, password);
        return studentList.stream().findFirst().orElse(null);
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
