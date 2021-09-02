package com.altshuler.it_education_springboot.feignClient;

import com.altshuler.it_education_springboot.model.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "courseFeign", url = "http://localhost:8080/api/v1")
public interface CourseFeignClient {

    @PostMapping("/courses")
    Course save(Course course);

    @DeleteMapping("/courses")
    Boolean delete (@RequestParam Integer id);

}
