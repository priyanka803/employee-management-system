package com.example.employee.services.impl;

import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Ram", 25, "Delhi"));
        employees.add(new Employee(2, "Shivam", 30, "Mumbai"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
}
