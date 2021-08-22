package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.WelcomeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_WELCOME;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WELCOME;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = WelcomeController.class)
public class WelcomeControllerTest extends MockInit {
    @Test
    void moveToWelcome() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WELCOME))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WELCOME));
    }
}
