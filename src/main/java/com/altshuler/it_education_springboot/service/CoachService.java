package com.altshuler.it_education_springboot.service;

import com.altshuler.it_education_springboot.model.Coach;

public interface CoachService {
    Coach add(Coach coach);

    boolean validate(String login, String password);

    void logIn(String login, String password);

    void deleteAll();

    Coach getById(int id);

    Coach checkCoach(String login, String password);
}
