package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminValidateController;
import com.altshuler.it_education_springboot.info.ProjectInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_VALIDATE;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.PARAM_ADMIN;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = AdminValidateController.class)
public class AdminValidateControllerTest extends MockInit {
    @Test
    void moveToAdminValidation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_VALIDATE))
                .andExpect(status().isOk())
                .andExpect(view().name(ProjectInfo.getRoles().get(PARAM_ADMIN)));
    }
}
