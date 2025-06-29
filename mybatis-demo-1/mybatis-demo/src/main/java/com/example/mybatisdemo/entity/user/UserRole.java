package com.example.mybatisdemo.entity.user;

/**
 * 用户角色枚举
 */
public enum UserRole {
    OWNER("房主"),
    FAMILY_MEMBER("家庭成员"),
    GUEST("访客");

    private final String description;

    UserRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}