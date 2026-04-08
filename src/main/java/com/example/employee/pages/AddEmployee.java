package com.example.employee.pages;

import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.impl.EmployeeServiceImpl;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

public class AddEmployee {
    @Property
    @Validate("required")
    private String name;
    @Property
    @Validate("required")
    private int age;
    @Property
    @Validate("required")
    private String address;

    @Inject
    private EmployeeService service;

    public Object onSuccess() {
        service.addEmployee(new Employee(
                (int)(Math.random()*1000),
                name, age, address
        ));
        return EmployeeList.class;
    }
}
