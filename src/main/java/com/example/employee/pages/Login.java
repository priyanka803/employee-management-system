package com.example.employee.pages;
import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeList;
import com.example.employee.services.LoginService;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;
//import org.apache.tapestry5.ioc.annotations.Inject;


import java.util.ArrayList;
import java.util.List;

public class Login {

//    @Inject
//    private LoginService loginService;

    @Property
    @Validate("required")
    private String username;

    @Property
    @Validate("required")
    private String password;

    @Property
    private boolean error;
//
//    public List<Employee> getEmployees() {
//        List<Employee> list = new ArrayList<>();
//
//        list.add(new Employee(1, "Priyanka", 25, "Delhi"));
//        list.add(new Employee(2, "Rahul", 30, "Noida"));
//
//        return list;
//    }
    Object onSuccess() {

//        if (loginService.validate(username, password)) {
//            return EmployeeList.class; // success page
//        }
        if (username.equals("priyanka") && password.equals("password")) {
            return Welcome.class; // success page
        }

        error = true;
        return null;
    }
}
