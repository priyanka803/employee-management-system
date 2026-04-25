package com.example.employee.services.impl;

import com.example.employee.constants.RoleEnum;
import com.example.employee.model.Role;
import com.example.employee.services.RoleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @PersistenceContext
    private EntityManager em;
    @Override
    public Role getRoleById(int id) {
        return em.find(Role.class, id);
    }
}
