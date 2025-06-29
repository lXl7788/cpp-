package com.example.mybatisdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisdemo.entity.device.device;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 用户服务接口
 */
public interface deviceService extends IService<device> {

    /**
     * 查询设备
     */
    device finddevice();

    /**
     * 根据设备类型查询设备
     */
    device findByDevice_type(String device_type);

    /**
     * 根据设备状态查询设备
     */
    device findByStatus(String status);

    /**
     * 更新设备状态
     */
    boolean updateStatus(Long id,String status);

    /**
     * 更新设备最后活跃时间
     */
    boolean updateLast_active_time(Long id,LocalDate last_active_time);

    /**
     * 更新设备已上传数据条数
     */
    boolean updateData_count(Long id,int data_count);

    /**
     * 不同设备类型的设备数量统计
     */
    List<Map<String, Object>> countByDevicetype();

    /**
     * 统计每种设备类型下，状态为 online 的设备数量
     */
    List<Map<String, Object>> countByDevicetype_online();

    /**
     * 查询最近7天内活跃（last_active_time）设备的平均 data_count
     */
    int countLast7day_avg_Datacount();

    /**
     * 删除设备
     */
    int DeleteDevice(Long id);

    /**
     * 创建设备
     */
    boolean createDevice(device device);
}