package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.info.ProjectInfo;
import com.altshuler.it_education_springboot.model.Admin;
import com.altshuler.it_education_springboot.repo.AdminRepository;
import com.altshuler.it_education_springboot.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.START_ADMIN_LOGIN;
import static com.altshuler.it_education_springboot.info.ProjectNamedConstants.START_ADMIN_PASSWORD;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public void initialize() {
        if (!ProjectInfo.IsAdminInitialized()) {
            ProjectInfo.setAdminInitialized(true);
            if (adminRepository.findAll().isEmpty()) {
                Admin admin = Admin.builder().id(1).login(START_ADMIN_LOGIN).password(START_ADMIN_PASSWORD).build();
                adminRepository.save(admin);
            }
        }
    }

    public void changeProperties(String login, String password) {
        Admin admin = adminRepository.getById(1);
        admin.setLogin(login);
        admin.setPassword(password);
        adminRepository.save(admin);
    }

    public boolean validate(String login, String password) {
        Admin admin = adminRepository.getById(1);
        return admin.getLogin().equals(login) && admin.getPassword().equals(password);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }


}
