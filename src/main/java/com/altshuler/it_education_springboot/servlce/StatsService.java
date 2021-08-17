package com.altshuler.it_education_springboot.servlce;



import com.altshuler.it_education_springboot.model.Stats;

import java.util.List;

public interface StatsService {
    Stats add(Stats stats);
    List<Stats> getAll();
    void deleteAll();
}
