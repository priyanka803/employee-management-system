package com.example.employee.services;

import com.example.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    public List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "Priyanka", 25, "Delhi"));
        list.add(new Employee(2, "Rahul", 30, "Noida"));

        return list;
    }
}
