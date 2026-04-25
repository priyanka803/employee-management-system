package com.example.employee.components;
import com.example.employee.constants.Gender;
import com.example.employee.model.Employee;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

public class WishBanner {

    @Parameter(required = true)
    @Property
    private Employee employee;
    public String getBannerColor() {
        if (employee == null || employee.getGender() == null) {
            return "#f8f9fa";
        }
        if (employee.getGender() == Gender.FEMALE) {
            return "#ffe4e1";
        } else if (employee.getGender() == Gender.MALE) {
            return "#e0f7fa";
        }

        return "#f8f9fa";
    }
}
