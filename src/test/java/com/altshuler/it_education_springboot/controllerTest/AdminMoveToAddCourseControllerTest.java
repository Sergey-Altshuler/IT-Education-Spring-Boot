package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminMoveToAddCourseController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_MOVE_TO_ADD_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADD_COURSE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = AdminMoveToAddCourseController.class)
public class AdminMoveToAddCourseControllerTest extends MockInit {
    @Test
    void moveToAddCourse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_MOVE_TO_ADD_COURSE))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADD_COURSE));
    }
}
