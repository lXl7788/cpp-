package com.example.mybatisdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisdemo.entity.device.device;
import com.example.mybatisdemo.mapper.DeviceMapper;
import com.example.mybatisdemo.service.deviceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class deviceServiceImpl extends ServiceImpl<DeviceMapper, device> implements deviceService {

    @Override
    public device finddevice() {
        return baseMapper.finddevice();
    }

    @Override
    public device findByDevice_type(String device_type) {
        return baseMapper.findByDevice_type(device_type);
    }

    @Override
    public device findByStatus(String status) {
        return baseMapper.findByStatus(status);
    }

    @Override
    public boolean updateStatus(Long id,String status) {
        return baseMapper.updateStatus(id, status) > 0;
    }

    @Override
    public boolean updateLast_active_time(Long id,LocalDate last_active_time) {
        return baseMapper.updateLast_active_time(id, last_active_time) > 0;
    }

    @Override
    public boolean updateData_count(Long id,int data_count) {
        return baseMapper.updateData_count(id, data_count) > 0;
    }

    @Override
    public List<Map<String, Object>> countByDevicetype() {
        return baseMapper.countByDevicetype();
    }

    @Override
    public List<Map<String, Object>> countByDevicetype_online() {
        return baseMapper.countByDevicetype();
    }

    @Override
    public int countLast7day_avg_Datacount() {
        return baseMapper.countLast7day_avg_Datacount();
    }

    @Override
    public int DeleteDevice(Long id) {
        return baseMapper.DeleteDevice(id);
    }

    @Override
    public boolean createDevice(device device) {
        return save(device);
    }
}