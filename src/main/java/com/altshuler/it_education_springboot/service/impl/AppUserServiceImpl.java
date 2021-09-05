package com.altshuler.it_education_springboot.service.impl;

import com.altshuler.it_education_springboot.model.AppUser;
import com.altshuler.it_education_springboot.repo.AppUserRepository;
import com.altshuler.it_education_springboot.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public AppUser add(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public boolean isSaved() {
        return appUserRepository.existsById(1);
    }
}
