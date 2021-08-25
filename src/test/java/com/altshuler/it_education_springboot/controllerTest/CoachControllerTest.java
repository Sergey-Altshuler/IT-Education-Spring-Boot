package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_CHOOSE_COURSE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class CoachControllerTest extends MockInit {
    @Test
    void moveToCoachEnter() throws Exception {
        Mockito.when(coachService.validate(TEST_COACH_LOGIN, TEST_COACH_PASSWORD)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_COACH_ENTER)
                .param(PARAM_LOGIN, TEST_COACH_LOGIN)
                .param(PARAM_PASSWORD, TEST_COACH_PASSWORD)
                .param(PARAM_REPEATED, TEST_COACH_CONFIRMED_PASSWORD))
                .andExpect(status().isOk())
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(view().name(PAGE_COACH_CHOOSE_COURSE));
    }

    @Test
    void moveToCoachRegister() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_COACH_MOVE_TO_REGISTER))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_COACH_REGISTER));
    }

    @Test
    void moveToCoachValidation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_COACH_VALIDATE))
                .andExpect(status().isOk())
                .andExpect(view().name(ProjectInfo.getRoles().get(PARAM_COACH)));
    }
}
