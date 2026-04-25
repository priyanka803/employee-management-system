package com.example.employee.services.impl;

import com.example.employee.constants.PermissionEnum;
import com.example.employee.model.Employee;
import com.example.employee.services.LoginService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    @PersistenceContext
    private EntityManager em;
//    @Override
//    public boolean validate(String username, String password) {
//        return USERNAME.equals(username) && PASSWORD.equals(password);
//    }
    @Override
    public Employee validate(String email, String password) {
        try {
            return em.createQuery(
                            "SELECT e FROM Employee e WHERE e.email=:e AND e.password=:p",
                            Employee.class)
                    .setParameter("e", email)
                    .setParameter("p", password)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    public boolean hasPermission(Employee emp, PermissionEnum permission) {

        if (emp == null || emp.getRole() == null) {
            return false;
        }
        return emp.getRole().getPermissions()
                .stream()
                .anyMatch(p -> p.getId()==permission.getId());
    }
}
