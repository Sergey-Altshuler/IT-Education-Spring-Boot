package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Coach;
import com.altshuler.it_education_springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LOGIN;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("from student s where s.login = :login AND s.password = :password")
    List<Student> getCoachWithCurrentData(@Param(PARAM_LOGIN) String login, @Param(PARAM_PASSWORD) String password);

}
