package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminMoveToChangePropertiesController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_MOVE_TO_CHANGE_PROPERTIES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_CHANGE_PROPERTIES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = AdminMoveToChangePropertiesController.class)
public class AdminMoveToChangePropertiesControllerTest extends MockInit {
    @Test
    void moveToChangeProperties() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_MOVE_TO_CHANGE_PROPERTIES))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_CHANGE_PROPERTIES));
    }
}
