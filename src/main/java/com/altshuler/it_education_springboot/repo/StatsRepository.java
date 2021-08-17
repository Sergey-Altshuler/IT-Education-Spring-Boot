package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsRepository extends JpaRepository<Stats, Integer> {
}
