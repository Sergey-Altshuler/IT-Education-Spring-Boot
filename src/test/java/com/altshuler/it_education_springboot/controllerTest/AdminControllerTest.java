package com.altshuler.it_education_springboot.controllerTest;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.util.ParseUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static com.altshuler.it_education_springboot.TestInfo.TestURLConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_COURSES;
import static com.altshuler.it_education_springboot.info.ProjectAttributeConstants.ATTR_STATS;
import static com.altshuler.it_education_springboot.info.ProjectPageConstants.*;
import static com.altshuler.it_education_springboot.info.ProjectParamConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc(addFilters = false)
public class AdminControllerTest extends MockInit {

    @Test
    void moveToAdminChangeProperties() throws Exception {
        Mockito.when(adminService.validate(TEST_ADMIN_LOGIN, TEST_ADMIN_PASSWORD)).thenReturn(true);
        this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADMIN_CHANGE_PROPERTIES)
                .param(PARAM_LOGIN, TEST_ADMIN_LOGIN)
                .param(PARAM_PASSWORD, TEST_ADMIN_PASSWORD)
                .param(PARAM_CHANGED, TEST_ADMIN_CHANGED_PASSWORD)
                .param(PARAM_REPEATED, TEST_ADMIN_CHANGED_PASSWORD))
                .andExpect(model().attribute(PARAM_PASSWORD, ParseUtil.encryptPassword(TEST_ADMIN_CHANGED_PASSWORD)))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_SUCCESS_CHANGE));
    }

    @Test
    void moveToAdminSuccessAddCourse() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post(URL_ADMIN_ADD_COURSE))
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_SUCCESS_ADD));
    }

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

    @Test
    void moveToAdminDisplayCourses() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_DISPLAY_COURSES))
                .andExpect(model().attribute(ATTR_COURSES, courseService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_DISPLAY_COURSES));
    }

    @Test
    void moveToAdminDisplayStats() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_DISPLAY_STATS))
                .andExpect(model().attribute(ATTR_STATS, statsService.getAll()))
                .andExpect(status().isOk())
                .andExpect(view().name(PAGE_ADMIN_DISPLAY_STATS));
    }


    @Test
    void moveToAdminValidation() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(URL_ADMIN_VALIDATE))
                .andExpect(status().isOk())
                .andExpect(view().name(ProjectInfo.getRoles().get(PARAM_ADMIN)));
    }
}
