package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_LOGIN;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_PASSWORD;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("from student s where s.login = :login")
    List<Student> getStudentWithCurrentData(@Param(PARAM_LOGIN) String login);

}
