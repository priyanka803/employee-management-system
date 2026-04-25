package com.example.employee.constants;

public enum RoleEnum {
    ADMIN(1),
    EMPLOYEE(2);

    private final int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
