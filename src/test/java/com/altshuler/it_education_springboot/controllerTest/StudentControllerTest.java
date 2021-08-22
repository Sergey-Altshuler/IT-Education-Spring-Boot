package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_STUDENT_ENTER;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_STUDENT_CHOOSE_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest extends MockInit {
    @Test
    void moveToStudentEnter() throws Exception {
        Mockito.when(studentService.validate(TEST_STUDENT_LOGIN, TEST_STUDENT_PASSWORD)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_STUDENT_ENTER)
                .param(PARAM_LOGIN, TEST_STUDENT_LOGIN)
                .param(PARAM_PASSWORD, TEST_STUDENT_PASSWORD)
                .param(PARAM_REPEATED, TEST_STUDENT_CONFIRMED_PASSWORD))
                .andExpect(status().isOk())
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(view().name(PAGE_STUDENT_CHOOSE_COURSE));
    }
}
