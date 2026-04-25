package com.example.employee.pages;
import com.example.employee.constants.PermissionEnum;
import com.example.employee.constants.RoleEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.User;
import com.example.employee.model.UserSession;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.LoginService;
import jakarta.inject.Inject;
import org.apache.tapestry5.ValidationTracker;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.services.PageRenderLinkSource;


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

    @SessionState
    private UserSession userSession;
    @Inject
    EmployeeService employeeService;
    @Inject
    private PageRenderLinkSource pageRenderLinkSource;
    @Inject
    private AlertManager alertManager;
    private Employee employee;

    public Object onSuccessFromLoginForm() {
        if (employee.getRole().getId()== RoleEnum.ADMIN.getId()) {
            return EmployeeList.class;
        }else if(employee.getRole().getId()== RoleEnum.EMPLOYEE.getId()){
            return pageRenderLinkSource.createPageRenderLinkWithContext(EmployeeDetails.class, employee.getId());
        }else {
            error = "Session expired! Login again";
            alertManager.error(error);
            return null;
        }
    }

//    void onValidateFromLoginForm(){
//        if (!loginService.validate(username, password)) {
//            // System.out.println("Invalid");
//            error = "Invalid credentials!";
//            tracker.recordError(error);
//        }
//    }
void onValidateFromLoginForm() {
        employee =loginService.validate(username, password);
    if (employee == null) {
        error = "Invalid Login";
        tracker.recordError(error);
        return;
    }
    userSession.setUser(employee);

    // return EmployeeList.class;
}
}
