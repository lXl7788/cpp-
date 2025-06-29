package com.example.mybatisdemo.entity.room;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 房间实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("room")
public class room {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 房间名称
     */
    @TableField("name")
    private String name;

    /**
     * 房间楼层
     */
    @TableField("floor")
    private String floor;

    /**
     * 房间类型
     */
    @TableField("type")
    private String type;

    /**
     * 房间面积(平方米)
     */
    @TableField("area")
    private Double area;

    /**
     * 房间描述
     */
    @TableField("description")
    private String description;

    /**
     * 所属家庭/房屋ID
     */
    @TableField("house_id")
    private Long houseId;

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