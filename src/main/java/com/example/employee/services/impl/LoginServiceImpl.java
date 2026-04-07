package com.example.employee.services.impl;

import com.example.employee.services.LoginService;

public class LoginServiceImpl implements LoginService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    @Override
    public boolean validate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
