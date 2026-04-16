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

    public Object onSuccessFromLoginForm() {
        return EmployeeList.class;
    }

    void onValidateFromLoginForm(){
        if (!loginService.validate(username, password)) {
            // System.out.println("Invalid");
            error = "Invalid credentials!";
            tracker.recordError(error);
        }
    }
}
