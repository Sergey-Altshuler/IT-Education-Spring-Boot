package com.altshuler.it_education_springboot.util;


import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.servlce.CoachService;
import com.altshuler.it_education_springboot.servlce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class HQLUtil {
    @Autowired
    CoachService coachService;
    @Autowired
    StudentService studentService;
    public Coach checkCoach(String login, String password) {
        List<Coach> queriedList = coachService.getCoachWithCurrentData(login, password);

        if ((queriedList == null) || (queriedList.size() == 0)) {
            return null;
        } else return queriedList.get(0);
    }

    public Student checkStudent(String login, String password) {
        List<Student> queriedList = studentService.getCoachWithCurrentData(login, password);
        if ((queriedList == null) || (queriedList.size() == 0)) {
            return null;
        } else return queriedList.get(0);
    }
}
