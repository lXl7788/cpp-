package com.example.mybatisdemo.entity.room;

/**
 * 房间类型枚举
 */
public enum roomType {
    LIVING_ROOM("客厅"),
    BEDROOM("卧室"),
    KITCHEN("厨房"),
    BATHROOM("卫生间"),
    STUDY("书房"),
    DINING_ROOM("餐厅"),
    BALCONY("阳台"),
    GARAGE("车库"),
    STORAGE("储藏室"),
    OTHER("其他");

    private final String description;

    roomType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}