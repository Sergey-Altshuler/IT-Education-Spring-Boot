package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.repo.CoachRepository;
import com.altshuler.it_education_springboot.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;
    private final PasswordEncoder passwordEncoder;

    public Coach add(Coach coach) {
        return coachRepository.save(coach);
    }

    public void deleteAll() {
        coachRepository.deleteAll();
    }

    public boolean validate(String login, String password) {
        return checkCoach(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setCoach(checkCoach(login, password));
    }

    public Coach getById(int id) {
        return coachRepository.getById(id);
    }

    @Override
    public Coach checkCoach(String login, String password) {
        Coach coach = coachRepository.getCoachWithCurrentData(login).stream().findFirst().orElse(null);
        boolean isPasswordCorrect = false;
        if (coach != null) {
            isPasswordCorrect = passwordEncoder.matches(password, coach.getPassword());
        }
        if (!isPasswordCorrect) {
            return null;
        } else return coach;
    }
}
