package com.example.employee.pages;

import com.example.employee.constants.PermissionEnum;
import com.example.employee.constants.RoleEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.UserSession;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.LoginService;
import com.example.employee.services.impl.EmployeeServiceImpl;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.SessionState;

public class EmployeeDetails {
    private int employeeId;

   @Inject
   private EmployeeService service;
   @SessionState
   private UserSession userSession;
   @Inject
   private LoginService loginService;

    public Employee getEmployee() {
        return service.getEmployeeById(employeeId);
    }

    void onActivate(int id) {
        this.employeeId = id;
    }
    public boolean isAdmin(){
        if (userSession == null || userSession.getEmployee() == null || userSession.getEmployee().getRole() == null) {
            return false;
        }
        return userSession.getEmployee().getRole().getId()== RoleEnum.ADMIN.getId();
    }
    public boolean getCanEdit() {
        return loginService.hasPermission(userSession.getEmployee(), PermissionEnum.EDIT);
    }

}
