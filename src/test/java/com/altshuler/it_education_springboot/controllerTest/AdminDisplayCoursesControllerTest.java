package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminDisplayCoursesController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_DISPLAY_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_COURSES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdminDisplayCoursesController.class)
public class AdminDisplayCoursesControllerTest extends MockInit {

    @Test
    void moveToAdminDisplayCourses() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_DISPLAY_COURSES))
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_DISPLAY_COURSES));
    }
}
