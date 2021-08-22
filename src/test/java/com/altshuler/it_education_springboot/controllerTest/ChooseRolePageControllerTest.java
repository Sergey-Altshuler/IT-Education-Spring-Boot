package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.ChooseRolePageController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_CHOOSE_ROLE_PAGE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_ROLE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = ChooseRolePageController.class)
public class ChooseRolePageControllerTest extends MockInit {
    @Test
    void moveToAddCourse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_CHOOSE_ROLE_PAGE))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_CHOOSE_ROLE));
    }
}
