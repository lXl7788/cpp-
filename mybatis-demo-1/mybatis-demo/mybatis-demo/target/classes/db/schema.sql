-- 创建数据库
CREATE DATABASE IF NOT EXISTS mybatis_demo DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE mybatis_demo;

-- 创建用户表
CREATE TABLE IF NOT EXISTS `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `username` VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名',
    `password` VARCHAR(128) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 创建设备表
CREATE TABLE IF NOT EXISTS `device` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    `device_name` VARCHAR(64) NOT NULL COMMENT '设备名称',
    `device_type` VARCHAR(32) NOT NULL COMMENT '设备类型（如传感器/执行器）',
    `harmony_version` VARCHAR(16) NOT NULL COMMENT '鸿蒙系统版本',
    `status` VARCHAR(16) NOT NULL COMMENT '设备状态（online/offline/maintenance）',
    `last_active_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后活跃时间',
    `data_count` INT COMMENT '设备已上传数据条数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备表';
