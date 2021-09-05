package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.model.Stats;
import com.altshuler.it_education_springboot.repo.StatsRepository;
import com.altshuler.it_education_springboot.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final StatsRepository statsRepository;

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
