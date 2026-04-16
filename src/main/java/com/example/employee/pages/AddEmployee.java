package com.example.employee.pages;

import com.example.employee.constants.Gender;
import com.example.employee.model.Employee;
import com.example.employee.services.EmployeeService;
import com.example.employee.services.impl.EmployeeServiceImpl;
import jakarta.inject.Inject;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.io.File;
import java.util.UUID;

public class AddEmployee {
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
    private UploadedFile file;
    @Property
    @Validate("required")
    private Gender gender;
    @Property
    @Validate("required")
    private String dob;

    @Inject
    private EmployeeService service;

    public Object onSuccess() {

        service.saveOrUpdateEmployee(new Employee(
                name,
                age,
                address,
                dob,
                gender,
                "Employee",
                uploadProfilePicture(file)
        ));

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
