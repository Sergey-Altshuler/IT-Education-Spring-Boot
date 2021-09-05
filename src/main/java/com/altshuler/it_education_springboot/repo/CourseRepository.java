package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_TITLE;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("from course c where c.title = :title")
    List<Course> getCoursesListWithCurrentTitle(@Param(PARAM_TITLE) String title);
}
