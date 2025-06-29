package com.example.mybatisdemo.entity.device;

/**
 * 设备状态枚举
 */
public enum deviceStatus {
    ON("开启"),
    OFF("关闭"),
    STANDBY("待机"),
    MALFUNCTION("故障");

    private final String description;

    deviceStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}