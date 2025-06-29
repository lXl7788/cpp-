package com.example.mybatisdemo.entity.sensor;

/**
 * 传感器类型枚举
 */
public enum sensorType {
    TEMPERATURE("温度传感器", "°C"),
    HUMIDITY("湿度传感器", "%"),
    AIR_QUALITY("空气质量传感器", "AQI"),
    LIGHT("光照传感器", "lux"),
    MOTION("人体感应传感器", null),
    SMOKE("烟雾传感器", null),
    GAS("可燃气体传感器", "ppm"),
    WATER_LEAK("水浸传感器", null),
    DOOR_WINDOW("门窗磁传感器", null),
    SOIL_MOISTURE("土壤湿度传感器", "%"),
    NOISE("噪音传感器", "dB"),
    PRESSURE("压力传感器", "kPa"),
    VOLTAGE("电压传感器", "V"),
    CURRENT("电流传感器", "A"),
    CO2("二氧化碳传感器", "ppm"),
    PM25("PM2.5传感器", "μg/m³");

    private final String description;
    private final String unit;

    sensorType(String description, String unit) {
        this.description = description;
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }
}