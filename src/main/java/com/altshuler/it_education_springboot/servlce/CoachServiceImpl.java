package com.altshuler.it_education_springboot.servlce;


import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.repo.CoachRepository;
import com.altshuler.it_education_springboot.util.HQLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    private final HQLUtil hqlUtil = new HQLUtil();
    @Autowired
    private CoachRepository coachRepository;

    public Coach add(Coach coach) {
        return coachRepository.save(coach);
    }
    public void deleteAll(){
        coachRepository.deleteAll();
    }

    public boolean validate(String login, String password) {
        return hqlUtil.checkCoach(login, password) != null;
    }

    public void logIn(String login, String password) {
        ProjectInfo.setCoach(hqlUtil.checkCoach(login, password));
    }
    public Coach getById(int id){
        return coachRepository.getById(id);
    }

    @Override
    public List<Coach> getCoachWithCurrentData(String login, String password) {
        return coachRepository.getCoachWithCurrentData(login, password);
    }
}
