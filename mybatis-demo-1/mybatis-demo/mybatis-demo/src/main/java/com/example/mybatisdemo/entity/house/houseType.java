package com.example.mybatisdemo.entity.house;

/**
 * 房屋类型枚举
 */
public enum houseType {
    APARTMENT("公寓"),
    VILLA("别墅"),
    TOWNHOUSE("联排别墅"),
    OFFICE("办公室"),
    SHOP("商铺"),
    OTHER("其他");

    private final String description;

    houseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}