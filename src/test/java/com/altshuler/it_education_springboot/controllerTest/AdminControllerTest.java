package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.TEST_ADMIN_LOGIN;
import static com.altshuler.it_education_springboot.TestInfo.TestConstants.TEST_ADMIN_PASSWORD;
import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_ENTER;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_ACTIONS;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest extends MockInit {

    @Test
    void moveToAdminEnter() throws Exception {
        Mockito.when(adminService.validate(TEST_ADMIN_LOGIN,TEST_ADMIN_PASSWORD)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADMIN_ENTER)
                .param(PARAM_LOGIN, TEST_ADMIN_LOGIN)
                .param(PARAM_PASSWORD, TEST_ADMIN_PASSWORD)
                .param(PARAM_REPEATED, TEST_ADMIN_PASSWORD))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_ACTIONS));
    }
}
