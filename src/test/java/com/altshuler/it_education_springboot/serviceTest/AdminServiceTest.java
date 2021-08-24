package com.altshuler.it_education_springboot.serviceTest;

import com.altshuler.it_education_springboot.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.altshuler.it_education_springboot.TestInfo.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    void validate() {
        adminService.initialize();
        assertTrue(adminService.validate(ADMIN_LOGIN, ADMIN_PASSWORD));
        adminService.changeProperties(ADMIN_LOGIN_CHANGED, ADMIN_PASSWORD_CHANGED);
        assertTrue(adminService.validate(ADMIN_LOGIN_CHANGED, ADMIN_PASSWORD_CHANGED));
    }

}
