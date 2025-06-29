package com.example.mybatisdemo.entity.permission;

/**
 * 权限类型枚举
 */
public enum permissionType {
    READ("只读权限", "只能查看设备状态"),
    CONTROL("控制权限", "可以控制设备"),
    ADMIN("管理权限", "可以配置设备参数");

    private final String name;
    private final String description;

    permissionType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}