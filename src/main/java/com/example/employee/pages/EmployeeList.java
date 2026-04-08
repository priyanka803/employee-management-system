package com.example.employee.pages;

import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.Property;
import java.util.List;

public class EmployeeList {

    @Inject
    private EmployeeService employeeService;
    @Property
    private Employee employee;

    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

}