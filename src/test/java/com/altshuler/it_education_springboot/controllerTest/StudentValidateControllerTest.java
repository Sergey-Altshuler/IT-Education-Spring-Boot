package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.StudentValidateController;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_STUDENT_VALIDATE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_STUDENT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = StudentValidateController.class)
public class StudentValidateControllerTest extends MockInit {
    @Test
    void moveToStudentValidation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_STUDENT_VALIDATE))
                .andExpect(status().isOk())
                .andExpect(view().name(ProjectInfo.getRoles().get(PARAM_STUDENT)));
    }
}
