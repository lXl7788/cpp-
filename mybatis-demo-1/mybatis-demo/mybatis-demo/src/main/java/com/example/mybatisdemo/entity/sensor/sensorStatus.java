package com.example.mybatisdemo.entity.sensor;

/**
 * 传感器状态枚举
 */
public enum sensorStatus {
    ONLINE("在线"),
    OFFLINE("离线"),
    FAULT("故障"),
    CALIBRATING("校准中");

    private final String description;

    sensorStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}