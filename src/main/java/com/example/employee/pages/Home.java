package com.example.employee.pages;

import org.apache.tapestry5.annotations.Property;

public class Home {
    @Property
    private String message;

    void setupRender() {
        message = "server time: " + new java.util.Date() + ".";
    }

}
