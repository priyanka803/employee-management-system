package com.example.employee.pages;

import com.example.employee.constants.Gender;
import com.example.employee.constants.RoleEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.UserSession;
import com.example.employee.services.EmployeeService;
import jakarta.inject.Inject;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.services.PageRenderLinkSource;

@Import(library = "context:js/validation.js")
public class EditEmployee {
    @Property
    @Validate("required")
    private String name;
    @Property
    @Validate("required")
    private int age;
    @Property
    @Validate("required")
    private String address;
    @Property
    @Validate("required")
    private Gender gender;
    @Property
    @Validate("required")
    private String dob;
    private int employeeId;
    @Inject
    private EmployeeService employeeService;
    @SessionState
    private UserSession userSession;
    @Inject
    private AlertManager alertManager;
    @Inject
    private PageRenderLinkSource pageRenderLinkSource;

    void onActivate(int id) {
        this.employeeId = id;
    }
    int onPassivate() {
        return employeeId;
    }
    void setupRender() {
        Employee emp = employeeService.getEmployeeById(employeeId);
        if (emp != null) {
            this.name = emp.getName();
            this.age = emp.getAge();
            this.address = emp.getAddress();
            this.dob = emp.getDob();
            this.gender = emp.getGender();
        }
    }
    public Object onSuccess() {
       Employee emp = employeeService.getEmployeeById(employeeId);
        emp.setName(name);
        emp.setAge(age);
        emp.setAddress(address);
        emp.setDob(dob);
        emp.setGender(gender);
        employeeService.saveOrUpdateEmployee(emp);
        if(userSession.getEmployee().getRole().getId()==RoleEnum.ADMIN.getId()) {
            return EmployeeList.class;
        } else if (userSession.getEmployee().getRole().getId()==RoleEnum.EMPLOYEE.getId()) {
           return pageRenderLinkSource.createPageRenderLinkWithContext(EmployeeDetails.class,employeeId);
        }else{
            alertManager.error("Session expired! Login again");
            return null;
        }

    }
}
