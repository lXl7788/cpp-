package com.example.mybatisdemo.entity.device;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 设备实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Device")
public class device {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 设备名称
     */
    @TableField("name")
    private String name;

    /**
     * 设备类型
     */
    @TableField("type")
    private String type;

    /**
     * 设备状态(ON-开启, OFF-关闭, STANDBY-待机)
     */
    @TableField("status")
    private String status;

    /**
     * 设备当前值 (如温度、亮度等)
     */
    @TableField("current_value")
    private String currentValue;

    /**
     * 所属房间ID
     */
    @TableField("room_id")
    private Long roomId;

    /**
     * IP地址
     */
    @TableField("ip_address")
    private String ipAddress;

    /**
     * MAC地址
     */
    @TableField("mac_address")
    private String macAddress;

    /**
     * 制造商
     */
    @TableField("manufacturer")
    private String manufacturer;

    /**
     * 设备型号
     */
    @TableField("model")
    private String model;

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