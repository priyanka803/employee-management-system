package com.example.employee.pages;
import com.example.employee.services.LoginService;
import jakarta.inject.Inject;
import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;


public class Index {

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

    @Environmental
    private ValidationTracker tracker;
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
        return EmployeeList.class;
    }
    void onValidate(){
        if (!loginService.validate(username, password)) {
            // System.out.println("Invalid");
            error = "Invalid credentials!";
            tracker.recordError(error);
        }
    }
//    void setupRender() {
//       // username = "Amit";
//        error="Invalid";
//    }

}
