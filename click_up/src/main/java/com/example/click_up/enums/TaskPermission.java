package com.example.click_up.enums;

public enum TaskPermission {
    READ("VIEW", "CAN ONLE READ"),
    WRITE("VIEW/WRITE", "CAN VIEW AND WRITE"),
    EDIT("VIEW/WRITE/EDIT", "CAN VIEW, WRITE AND EDIT"),
    FULL_ACCESS("VIEW/WRITE/EDIT/DELETE", "CAN FULL ACCESS");


    public final String name;
    public final String description;

    TaskPermission(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
