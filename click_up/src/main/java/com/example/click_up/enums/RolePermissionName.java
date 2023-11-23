package com.example.click_up.enums;

public enum RolePermissionName {
    SOME_PERMISSION("read", "can read any data for workspace");

    public final String name;
    public final String description;

    RolePermissionName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
