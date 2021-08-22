package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.StartController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_CHOOSE_LANGUAGE;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_CHOOSE_LANGUAGE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = StartController.class)
public class StartControllerTest extends MockInit {

    @Test
    void moveToStartPage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_CHOOSE_LANGUAGE))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_CHOOSE_LANGUAGE));
    }
}
