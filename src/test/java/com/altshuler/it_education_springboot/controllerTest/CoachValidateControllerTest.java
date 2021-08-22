package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.CoachValidateController;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_COACH_VALIDATE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_COACH;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = CoachValidateController.class)
public class CoachValidateControllerTest extends MockInit {
    @Test
    void moveToCoachValidation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_COACH_VALIDATE))
                .andExpect(status().isOk())
                .andExpect(view().name(ProjectInfo.getRoles().get(PARAM_COACH)));
    }
}
