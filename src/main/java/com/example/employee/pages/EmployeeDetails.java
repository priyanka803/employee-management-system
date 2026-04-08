package com.example.employee.pages;

import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.impl.EmployeeServiceImpl;
import jakarta.inject.Inject;

public class EmployeeDetails {
    private int employeeId;

   @Inject
    private EmployeeService service;

    public Employee getEmployee() {
        return service.getEmployeeById(employeeId);
    }

    void onActivate(int id) {
        this.employeeId = id;
    }
}
