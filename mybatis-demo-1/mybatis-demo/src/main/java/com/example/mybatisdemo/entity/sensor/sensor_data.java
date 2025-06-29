package com.example.mybatisdemo.entity.sensor;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 传感器数据记录实体类
 */
@Data
@TableName("sensor_data")
public class sensor_data {

    /**
     * 记录ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 传感器ID
     */
    @TableField("sensor_id")
    private Long sensorId;

    /**
     * 记录值
     */
    @TableField("record_value")
    private String value;

    /**
     * 记录时间
     */
    @TableField("record_time")
    private LocalDateTime recordTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}