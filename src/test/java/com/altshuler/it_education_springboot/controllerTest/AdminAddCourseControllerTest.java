package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminAddCourseController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_ADD_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_ADD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdminAddCourseController.class)
public class AdminAddCourseControllerTest extends MockInit {
    @Test
    void moveToAdminAddCourse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADMIN_ADD_COURSE))
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_SUCCESS_ADD));
    }
}
