package com.altshuler.it_education_springboot.repo;

import com.altshuler.it_education_springboot.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

}
