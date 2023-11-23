package com.example.click_up.enums;

public enum RoleName {
    SYSTEM_ADMIN("admin", "can all works"),
    SYSTEM_MODER("moderator", "can many works"),
    SYSTEM_USER("user", "can some works");
    public final String name;
    public final String description;

    RoleName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
