package com.altshuler.it_education_springboot.service;


import com.altshuler.it_education_springboot.model.Stats;
import com.altshuler.it_education_springboot.repo.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {
    @Autowired
    private StatsRepository statsRepository;
    public Stats add(Stats stats) {
        return statsRepository.save(stats);
    }

    public List<Stats> getAll() {
        return statsRepository.findAll();
    }

    public void deleteAll() {
        statsRepository.deleteAll();
    }
}
