package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.WrongDataController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_WRONG_DATA;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_DATA;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = WrongDataController.class)
public class WrongDataControllerTest extends MockInit {
    @Test
    void moveToWrongData() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WRONG_DATA))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WRONG_DATA));
    }
}
