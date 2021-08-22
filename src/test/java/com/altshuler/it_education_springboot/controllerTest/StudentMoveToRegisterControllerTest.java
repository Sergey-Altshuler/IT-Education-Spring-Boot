package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.StudentMoveToRegisterController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_STUDENT_MOVE_TO_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_REGISTER;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = StudentMoveToRegisterController.class)
public class StudentMoveToRegisterControllerTest extends MockInit {
    @Test
    void moveToStudentEnter() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_STUDENT_MOVE_TO_REGISTER))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_STUDENT_REGISTER));
    }
}
