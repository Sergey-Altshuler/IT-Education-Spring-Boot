package com.altshuler.it_education_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.altshuler.it_education_springboot.repo")
@EntityScan("com.altshuler.it_education_springboot.model")
public class ItEducationSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItEducationSpringBootApplication.class, args);
    }

}
