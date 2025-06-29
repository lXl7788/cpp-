package com.example.mybatisdemo.entity.house;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 房屋实体类
 */
@Data
@TableName("house")
public class house {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 房屋名称
     */
    @TableField("name")
    private String name;

    /**
     * 房屋地址
     */
    @TableField("address")
    private String address;

    /**
     * 房屋面积(平方米)
     */
    @TableField("area")
    private Double area;

    /**
     * 房屋类型
     */
    @TableField("type")
    private String type;

    /**
     * 房主用户ID
     */
    @TableField("owner_id")
    private Long ownerId;

    /**
     * 房屋描述
     */
    @TableField("description")
    private String description;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标志 (0-未删除, 1-已删除)
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}