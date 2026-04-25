package com.example.employee.services;

import com.example.employee.constants.PermissionEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.User;

public interface LoginService {
    //boolean validate(String username, String password);
    public Employee validate(String email, String password);
    public boolean hasPermission(Employee emp, PermissionEnum permission);
    }
