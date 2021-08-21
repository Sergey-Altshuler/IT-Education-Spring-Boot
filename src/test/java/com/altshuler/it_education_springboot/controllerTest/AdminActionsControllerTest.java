package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminActionsController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_ACTIONS;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = AdminActionsController.class)
public class AdminActionsControllerTest extends MockInit{
    @Test
    void moveToAdminActions() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/adminActions/"))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_ACTIONS));
    }
}
