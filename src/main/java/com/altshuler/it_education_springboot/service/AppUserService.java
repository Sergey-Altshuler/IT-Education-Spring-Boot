package com.altshuler.it_education_springboot.service;

import com.altshuler.it_education_springboot.model.AppUser;

public interface AppUserService {
    AppUser add(AppUser appUser);
    boolean isSaved();
}
