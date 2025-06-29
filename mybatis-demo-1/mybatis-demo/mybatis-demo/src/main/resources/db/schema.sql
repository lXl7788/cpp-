-- 创建数据库
CREATE DATABASE IF NOT EXISTS mybatis_demo DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE mybatis_demo;

-- 创建用户表
CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
    `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加密密码',
    `role` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色(OWNER/FAMILY/GUEST)',
    `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
    `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
    `status` tinyint NOT NULL DEFAULT '1' COMMENT '状态(0-禁用,1-启用)',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- 创建设备表
CREATE TABLE `device` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '设备ID',
    `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备名称',
    `type` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '设备类型',
    `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'OFF' COMMENT '设备状态',
    `current_value` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '当前值',
    `room_id` bigint NOT NULL COMMENT '所属房间ID',
    `ip_address` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
    `mac_address` varchar(17) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'MAC地址',
    `manufacturer` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '制造商',
    `model` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '型号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    KEY `idx_room_id` (`room_id`),
    KEY `idx_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='设备表';

-- 创建权限表
CREATE TABLE `permission` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
    `user_id` bigint NOT NULL COMMENT '用户ID',
    `device_id` bigint NOT NULL COMMENT '设备ID',
    `permission_type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限类型',
    `start_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '生效时间',
    `expiry_time` datetime DEFAULT NULL COMMENT '过期时间',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_device` (`user_id`,`device_id`),
    KEY `idx_device` (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表';

-- 创建房屋表
CREATE TABLE `house` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
    `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋名称',
    `address` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋地址',
    `area` decimal(10,2) DEFAULT NULL COMMENT '房屋面积(㎡)',
    `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房屋类型',
    `owner_id` bigint NOT NULL COMMENT '房主用户ID',
    `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房屋描述',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    KEY `idx_owner` (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房屋表';

-- 创建房间表
CREATE TABLE `room` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '房间ID',
    `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间名称',
    `floor` int NOT NULL COMMENT '所在楼层',
    `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '房间类型',
    `area` decimal(10,2) DEFAULT NULL COMMENT '房间面积(㎡)',
    `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '房间描述',
    `house_id` bigint NOT NULL COMMENT '所属房屋ID',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    KEY `idx_house` (`house_id`),
    KEY `idx_floor` (`floor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='房间表';

-- 创建传感器表
CREATE TABLE `sensor` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '传感器ID',
    `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '传感器名称',
    `type` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '传感器类型',
    `current_value` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '当前值',
    `unit` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数值单位',
    `room_id` bigint NOT NULL COMMENT '所属房间ID',
    `device_id` bigint DEFAULT NULL COMMENT '关联设备ID',
    `ip_address` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
    `mac_address` varchar(17) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'MAC地址',
    `report_interval` int DEFAULT '60' COMMENT '上报频率(秒)',
    `last_report_time` datetime DEFAULT NULL COMMENT '最后上报时间',
    `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ONLINE' COMMENT '传感器状态',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除(0-未删,1-已删)',
    PRIMARY KEY (`id`),
    KEY `idx_room` (`room_id`),
    KEY `idx_device` (`device_id`),
    KEY `idx_type` (`type`),
    KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='传感器表';

-- 创建传感器数据表
CREATE TABLE `sensor_data` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
    `sensor_id` bigint NOT NULL COMMENT '传感器ID',
    `record_value` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '记录值',
    `record_time` datetime NOT NULL COMMENT '记录时间',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY `idx_sensor` (`sensor_id`),
    KEY `idx_record_time` (`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='传感器数据记录表';
