package com.notimplement.happygear.model.enums;

public enum UserRole {
    ROLE_ADMIN(0),
    ROLE_USER(1),
    ROLE_MANAGER(2);

    Integer value;

    private Integer getValue(Integer value){
        return this.value;
    }

    private UserRole(Integer value){
        this.value = value;
    }
}
