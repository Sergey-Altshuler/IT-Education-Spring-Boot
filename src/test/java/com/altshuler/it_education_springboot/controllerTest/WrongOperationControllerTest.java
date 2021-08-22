package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.WrongOperationController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_WRONG_OPERATION;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_WRONG_OPERATION;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = WrongOperationController.class)
public class WrongOperationControllerTest extends MockInit {
    @Test
    void moveToWrongOperation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_WRONG_OPERATION))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_WRONG_OPERATION));
    }
}
