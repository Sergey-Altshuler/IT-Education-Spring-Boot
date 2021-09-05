package com.altshuler.it_education_springboot.service;

public interface AdminService {
    void initialize();

    void changeProperties(String login, String password);

    boolean validate(String login, String password);
    void deleteAll();
}
