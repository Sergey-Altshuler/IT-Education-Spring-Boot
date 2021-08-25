package com.altshuler.it_education_springboot.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
public class PageControllerTest extends MockInit {
    @Test
    void moveToAddCourse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_CHOOSE_ROLE_PAGE))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_CHOOSE_ROLE));
    }

    @Test
    void moveToStartPage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_CHOOSE_LANGUAGE))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_CHOOSE_LANGUAGE));
    }

    @Test
    void moveToWelcome() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WELCOME))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WELCOME));
    }

    @Test
    void moveToWrongData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WRONG_DATA))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WRONG_DATA));
    }

    @Test
    void moveToWrongOperation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WRONG_OPERATION))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WRONG_OPERATION));
    }
}
