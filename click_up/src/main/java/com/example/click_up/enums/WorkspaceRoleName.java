package com.example.click_up.enums;

public enum WorkspaceRoleName {
    WORKSPACE_OWNER("owner", "can all works for workspace"),
    WORKSPACE_ADMIN("admin", "can many works for workspace"),
    WORKSPACE_USER("user", "can some works for workspace"),
    WORKSPACE_GUEST("guest", "can some works for workspace");
    public final String name;
    public final String description;

    WorkspaceRoleName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
