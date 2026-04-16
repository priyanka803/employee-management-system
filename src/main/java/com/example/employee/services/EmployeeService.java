package com.example.employee.services;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void saveOrUpdateEmployee(Employee emp);
}
