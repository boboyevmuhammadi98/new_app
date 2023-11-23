package com.example.click_up.enums;

public enum DependencyTaskName {
    WAITING("waiting", "some desc"),
    BLOCKING("bocking", "some desc");

    public final String name;
    public final String description;

    DependencyTaskName(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
