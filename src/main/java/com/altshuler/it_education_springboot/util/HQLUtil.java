package com.altshuler.it_education_springboot.util;


import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Student;
import com.altshuler.it_education_springboot.servlce.CoachServiceImpl;
import com.altshuler.it_education_springboot.servlce.StudentServiceImpl;

import java.util.List;

public class HQLUtil {
    public Coach checkCoach(String login, String password) {
        List<Coach> queriedList = new CoachServiceImpl().getCoachWithCurrentData(login, password);

        if ((queriedList == null) || (queriedList.size() == 0)) {
            return null;
        } else return queriedList.get(0);
    }

    public Student checkStudent(String login, String password) {
        List<Student> queriedList = new StudentServiceImpl().getCoachWithCurrentData(login, password);
        if ((queriedList == null) || (queriedList.size() == 0)) {
            return null;
        } else return queriedList.get(0);
    }
}
