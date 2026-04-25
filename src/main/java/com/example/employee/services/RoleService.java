package com.example.employee.services;

import com.example.employee.model.Role;
import org.springframework.stereotype.Service;

public interface RoleService {
    public Role getRoleById(int id);
}
