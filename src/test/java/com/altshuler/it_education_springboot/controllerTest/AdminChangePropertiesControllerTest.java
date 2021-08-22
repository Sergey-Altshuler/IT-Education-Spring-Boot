package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminChangePropertiesController;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_CHANGE_PROPERTIES;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdminChangePropertiesController.class)
public class AdminChangePropertiesControllerTest extends MockInit {
    ParseUtil parseUtil = new ParseUtil();

    @Test
    void moveToAdminChangeProperties() throws Exception {
        Mockito.when(adminService.validate(TEST_ADMIN_LOGIN, TEST_ADMIN_PASSWORD)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADMIN_CHANGE_PROPERTIES)
                .param(PARAM_LOGIN, TEST_ADMIN_LOGIN)
                .param(PARAM_PASSWORD, TEST_ADMIN_PASSWORD)
                .param(PARAM_CHANGED, TEST_ADMIN_CHANGED_PASSWORD)
                .param(PARAM_REPEATED, TEST_ADMIN_CHANGED_PASSWORD))
                .andExpect(model().attribute(PARAM_PASSWORD, parseUtil.encryptPassword(TEST_ADMIN_CHANGED_PASSWORD)))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_SUCCESS_CHANGE));
    }
}
