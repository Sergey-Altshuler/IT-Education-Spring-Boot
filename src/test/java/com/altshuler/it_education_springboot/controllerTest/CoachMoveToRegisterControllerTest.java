package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.CoachMoveToRegisterController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_COACH_MOVE_TO_REGISTER;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_COACH_REGISTER;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = CoachMoveToRegisterController.class)
public class CoachMoveToRegisterControllerTest extends MockInit {
    @Test
    void moveToCoachEnter() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_COACH_MOVE_TO_REGISTER))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_COACH_REGISTER));
    }
}
