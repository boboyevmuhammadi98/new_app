package com.example.click_up.enums;

public enum WorkspaceRolePermissionName {
    SOME_PERMISSION("some permission", "can some work for workspace");

    public final String name;
    public final String description;

    WorkspaceRolePermissionName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
