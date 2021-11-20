package com.example.demo.enums;

public enum UserPermission {
 VISITOR_READ("user:read"),
 VISITOR_WRITE("user:write"),
 ESTATES_READ("estates_read"),
 ESTATES_WRITE("estates_write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public  String getPermission(){
        return permission;
    }
}
