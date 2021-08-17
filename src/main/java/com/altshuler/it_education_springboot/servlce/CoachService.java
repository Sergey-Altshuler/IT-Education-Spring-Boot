package com.altshuler.it_education_springboot.servlce;


import com.altshuler.it_education_springboot.model.Coach;

import java.util.List;

public interface CoachService {
    Coach add(Coach coach);

    boolean validate(String login, String password);

    void logIn(String login, String password);
    void deleteAll();
    Coach getById(int id);
    List<Coach> getCoachWithCurrentData(String login, String password);
}
