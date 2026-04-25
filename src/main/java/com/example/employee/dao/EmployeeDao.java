package com.example.employee.dao;

import com.example.employee.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void saveOrUpdateEmployee(Employee employee);
    public Employee getById(int id);
    public List<Employee> getAll();
    public Employee getByEmail(String email);
    }
