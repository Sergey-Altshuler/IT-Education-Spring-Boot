package com.altshuler.it_education_springboot.servlce;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.repo.StudentRepository;
import com.altshuler.it_education_springboot.util.HQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private final HQLUtil hqlUtil = new HQLUtil();

    public Student add(Student student) {
        return studentRepository.save(student);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> getCoachWithCurrentData(String login, String password) {
        return studentRepository.getCoachWithCurrentData(login, password);
    }

    public Student getById(int id) {
        return studentRepository.getById(id);
    }

    public boolean validate(String login, String password) {
        return hqlUtil.checkStudent(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setStudent(hqlUtil.checkStudent(login, password));
    }


}
