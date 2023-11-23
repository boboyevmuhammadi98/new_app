package com.example.click_up.enums;

public enum StatusName {
    OPEN("new task", "soe description"),
    CUSTOM("progress", "soe description"),
    CLOSED("completed task", "some description");

    public final String name;
    public final String description;

    StatusName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
