package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LOGIN;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;
@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    @Query("from coach c where c.login = :login AND c.password = :password")
    List<Coach> getCoachWithCurrentData(@Param(PARAM_LOGIN) String login, @Param(PARAM_PASSWORD) String password);
}
