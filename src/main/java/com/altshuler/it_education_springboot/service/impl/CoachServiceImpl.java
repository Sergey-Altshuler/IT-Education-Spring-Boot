package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.repo.CoachRepository;
import com.altshuler.it_education_springboot.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    public Coach add(Coach coach) {
        return coachRepository.save(coach);
    }
    public void deleteAll(){
        coachRepository.deleteAll();
    }

    public boolean validate(String login, String password) {
        return checkCoach(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setCoach(checkCoach(login, password));
    }
    public Coach getById(int id){
        return coachRepository.getById(id);
    }

    @Override
    public Coach checkCoach(String login, String password) {
        List<Coach> coachList = coachRepository.getCoachWithCurrentData(login, password);
        return coachList.stream().findFirst().orElse(null);
    }
}
