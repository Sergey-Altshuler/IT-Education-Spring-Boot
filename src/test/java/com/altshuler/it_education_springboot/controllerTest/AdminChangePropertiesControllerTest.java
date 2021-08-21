package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminChangePropertiesController;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_SUCCESS_CHANGE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdminChangePropertiesController.class)
public class AdminChangePropertiesControllerTest extends MockInit{
    ParseUtil parseUtil = new ParseUtil();
    @Test
    void moveToAdminChangeProperties() throws Exception {
        Mockito.when(adminService.validate("admin","password")).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/adminChangeProperties/")
                .param(PARAM_LOGIN, "admin")
                .param(PARAM_PASSWORD, "password")
                .param(PARAM_CHANGED, "newPass")
                .param(PARAM_REPEATED, "newPass"))
                .andExpect(model().attribute(PARAM_PASSWORD, parseUtil.encryptPassword("newPass")))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_SUCCESS_CHANGE));
    }
}
