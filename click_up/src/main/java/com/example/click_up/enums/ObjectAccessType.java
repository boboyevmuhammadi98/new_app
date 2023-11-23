package com.example.click_up.enums;

public enum ObjectAccessType {
    PUBLIC("public", "for all members"),
    PRIVATE("private", "for accepted members");

    public final String name;
    public final String description;

    ObjectAccessType(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
