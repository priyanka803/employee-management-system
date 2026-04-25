package com.example.employee.pages;

import com.example.employee.constants.Gender;
import com.example.employee.constants.RoleEnum;
import com.example.employee.model.Employee;
import com.example.employee.model.Role;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.RoleService;
import com.example.employee.services.impl.EmployeeServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.File;
import java.util.UUID;

@Import(library = "context:js/validation.js")
public class AddEmployee {
    @Property
    @Validate("required")
    private String name;
    @Property
    @Validate("required")
    //@Validate("required, min=18, max=60")
    private int age;
    @Property
    @Validate("required")
    private String address;
    @Property
    @Validate("required")
    private UploadedFile file;
    @Property
    @Validate("required")
    private Gender gender;
    @Property
    @Validate("required")
    private String dob;
    @Property
    private String email;
    @Property
    private String password;
    @Inject
    private EmployeeService employeeService;
    @Inject
    private RoleService roleService;


    public Object onSuccess() {
        Role role = roleService.getRoleById(RoleEnum.EMPLOYEE.getId());
        Employee emp=new Employee();
        emp.setName(name);
        emp.setAge(age);
        emp.setAddress(address);
        emp.setDesignation("Employee");
        emp.setDob(dob);
        emp.setGender(gender);
        emp.setFileName(uploadProfilePicture(file));
        emp.setEmail(email);
        emp.setPassword(password);
        emp.setRole(role);
        employeeService.saveOrUpdateEmployee(emp);

        return EmployeeList.class;

    }
    private String  uploadProfilePicture(UploadedFile file){
        String fileName = null;
        try {
            if (file != null) {
                String originalFileName = file.getFileName();
                String uniqueFileName = UUID.randomUUID() + "_" + originalFileName;
                String uploadDir = "src/main/webapp/images/";
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File fileUpload = new File(dir, uniqueFileName);
                file.write(fileUpload);

                fileName = uniqueFileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
