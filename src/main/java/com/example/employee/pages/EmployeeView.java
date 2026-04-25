package com.example.employee.pages;

import com.example.employee.model.Employee;
import com.example.employee.model.Permission;
import com.example.employee.model.UserSession;
import com.example.employee.services.EmployeeService;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.services.PageRenderLinkSource;

@Import(stylesheet = "context:css/style.css")
public class EmployeeView {

    @Inject
    private EmployeeService employeeService;

    @Property
    private Employee employee;

    @Persist
    private int employeeId;
    @Property
    @Persist
    private boolean showImagePopup;
    @Inject
    private PageRenderLinkSource pageRenderLinkSource;

    void onActivate(int id) {
        this.employeeId = id;
    }

    int onPassivate() {
        return employeeId;
    }

    void setupRender() {
        employee = employeeService.getEmployeeById(employeeId);
    }

    Object onPromote() {
        employee = employeeService.getEmployeeById(employeeId);
        employee.setId(employeeId);
        employee.setDesignation("Manager");
        employeeService.saveOrUpdateEmployee(employee);
        return pageRenderLinkSource.createPageRenderLinkWithContext(EmployeeDetails.class, employeeId);
    }
    void onActionFromShowImage() {
        showImagePopup = true;
    }

}

