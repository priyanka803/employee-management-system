package com.example.employee.pages;
import com.example.employee.services.LoginService;
import com.example.employee.services.impl.LoginServiceImpl;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;


public class Login {

    @Inject
    private LoginService loginService;

    //  private LoginService loginService=new LoginServiceImpl();

    @Property
    @Validate("required")
    private String username;

    @Property
    @Validate("required")
    private String password;

    @Property
    private String error;
//
//    public List<Employee> getEmployees() {
//        List<Employee> list = new ArrayList<>();
//
//        list.add(new Employee(1, "Priyanka", 25, "Delhi"));
//        list.add(new Employee(2, "Rahul", 30, "Noida"));
//
//        return list;
//    }

    public Object onSuccess() {
        if (!loginService.validate(username, password)) {
            error = "Invalid credentials!";
            return null;
        }
        return EmployeeList.class;
        //return Welcome.class;

    }

}
