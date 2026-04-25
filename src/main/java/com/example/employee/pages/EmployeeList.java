package com.example.employee.pages;

import com.example.employee.constants.PermissionEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.Permission;
import com.example.employee.model.UserSession;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.LoginService;
import jakarta.inject.Inject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import java.time.LocalDate;
import java.util.List;

public class EmployeeList {

    @Inject
    private EmployeeService employeeService;
    @Property
    private Employee employee;

    @Property
    private boolean isBirthday;
    @Property
    private Employee birthdayEmployee;
    @Property
    @SessionState
    private UserSession userSession;
    @Inject
    private LoginService loginService;


    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    void setupRender(){
        if (userSession == null || userSession.getEmployee() == null) {
            return;
        }
        for(Employee emp:getEmployees()){
            String todayString = LocalDate.now().toString();
            String todayMMDD = todayString.substring(5);
            String fullDob = emp.getDob();
            String dobMMDD = fullDob.substring(5);
          //  System.out.println("dob"+dobMMDD);
            if(dobMMDD.equals(todayMMDD)){
                isBirthday=true;
                birthdayEmployee=emp;
                break;
            }
        }
    }
    public boolean getCanView() {
        return loginService.hasPermission(userSession.getEmployee(), PermissionEnum.VIEW);
    }
    public boolean getCanAdd() {
        return loginService.hasPermission(userSession.getEmployee(), PermissionEnum.ADD);
    }
    public String getGridAddedColumns() {
        if (getCanView()) {
            return "action";
        }
        return "";
    }

}