package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
