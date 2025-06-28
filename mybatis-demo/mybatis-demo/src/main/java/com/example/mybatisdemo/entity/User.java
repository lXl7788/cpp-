package com.example.mybatisdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 确认密码
     */
    @TableField(exist = false)
    private String confirmPassword;

//    /**
//     * 逻辑删除标志：0-未删除，1-已删除
//     */
//    @TableLogic
//    @TableField("deleted")
//    private Integer deleted;
} 