package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.controller.AdminDisplayStatsController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.URL_ADMIN_DISPLAY_STATS;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_STATS;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.PAGE_ADMIN_DISPLAY_STATS;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AdminDisplayStatsController.class)
public class AdminDisplayStatsControllerTest extends MockInit {
    @Test
    void moveToAdminDisplayStats() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_DISPLAY_STATS))
                .andExpect(model().attribute(ATTR_STATS, statsService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_DISPLAY_STATS));
    }
}
