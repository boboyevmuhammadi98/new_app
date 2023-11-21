package uz.alif.authentication_news_app.enums;

public enum Permission {
    VIEW_USER(GroupOfPermission.USER),
    ADD_USER(GroupOfPermission.USER),
    EDIT_USER(GroupOfPermission.USER),
    DELETE_USER(GroupOfPermission.USER),

    VIEW_POST(GroupOfPermission.POST),
    ADD_POST(GroupOfPermission.POST),
    EDIT_POST(GroupOfPermission.POST),
    DELETE_POST(GroupOfPermission.POST),

    VIEW_ROLE(GroupOfPermission.ROLE),
    ADD_ROLE(GroupOfPermission.ROLE),
    EDIT_ROLE(GroupOfPermission.ROLE),
    DELETE_ROLE(GroupOfPermission.ROLE),

    VIEW_COMMENT(GroupOfPermission.COMMENT),
    ADD_COMMENT(GroupOfPermission.COMMENT),
    EDIT_COMMENT(GroupOfPermission.COMMENT),
    DELETE_COMMENT(GroupOfPermission.COMMENT),
    DELETE_MY_COMMENT(GroupOfPermission.COMMENT);

    public final GroupOfPermission groupOfPermission;

    Permission(GroupOfPermission groupOfPermission) {
        this.groupOfPermission = groupOfPermission;
    }

    private enum GroupOfPermission {
        USER("working with user"),
        POST("working with post"),
        ROLE("working with role"),
        COMMENT("working with comment");
        public final String description;

        GroupOfPermission(String description) {
            this.description = description;
        }
    }
}
