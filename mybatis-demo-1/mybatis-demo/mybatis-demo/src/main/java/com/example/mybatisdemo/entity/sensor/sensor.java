package com.example.mybatisdemo.entity.sensor;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 传感器实体类
 */
@Data
@TableName("sensor")
public class sensor {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 传感器名称
     */
    @TableField("name")
    private String name;

    /**
     * 传感器类型
     */
    @TableField("type")
    private String type;

    /**
     * 当前传感器值
     */
    @TableField("current_value")
    private String currentValue;

    /**
     * 数值单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 所属房间ID
     */
    @TableField("room_id")
    private Long roomId;

    /**
     * 设备ID
     */
    @TableField("device_id")
    private Long deviceId;

    /**
     * IP地址 (联网传感器)
     */
    @TableField("ip_address")
    private String ipAddress;

    /**
     * MAC地址
     */
    @TableField("mac_address")
    private String macAddress;

    /**
     * 上报频率 (秒)
     */
    @TableField("report_interval")
    private Integer reportInterval;

    /**
     * 最后上报时间
     */
    @TableField("last_report_time")
    private LocalDateTime lastReportTime;

    /**
     * 状态 (ONLINE-在线, OFFLINE-离线, FAULT-故障)
     */
    @TableField("status")
    private String status;

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