package com.example.mybatisdemo.entity.device;

/**
 * 设备类型枚举
 */
public enum deviceType {
    LIGHT("灯光"),
    CURTAIN("窗帘"),
    AIR_CONDITIONER("空调"),
    FAN("风扇"),
    fridge("冰箱"),
    TV("电视"),
    WATER_PUMP("水泵"),
    DOOR_LOCK("门锁"),
    CAMERA("摄像头"),
    SENSOR("传感器"),
    SMART_SPEAKER("智能音箱"),
    OTHER("其他");

    private final String description;

    deviceType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}