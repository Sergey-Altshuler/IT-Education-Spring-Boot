package com.altshuler.it_education_springboot.service;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.repo.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

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
        if ((coachList == null) || (coachList.size() == 0)) {
            return null;
        } else return coachList.get(0);
    }
}
