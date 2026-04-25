package com.example.employee.constants;

public enum PermissionEnum {
    EDIT(1),
    VIEW(2),
    ADD(3);

    private final int id;

    PermissionEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
