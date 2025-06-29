package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.device.device;
import com.example.mybatisdemo.service.deviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备控制器
 * 提供RESTful API接口
 */
@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "*")
public class DeviceController {

    @Autowired
    private deviceService deviceService;

    /**
     * 创建设备
     */
    @PostMapping("/creat_device")
    public ResponseEntity<Map<String, Object>> createDevice(@RequestBody device device) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = deviceService.createDevice(device);
            if (success) {
                response.put("success", true);
                response.put("message", "设备创建成功");
                response.put("data", device);
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "设备创建失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 查询所有设备
     */
    @GetMapping("/search_device")
    public ResponseEntity<Map<String, Object>> finddevice() {
        Map<String, Object> response = new HashMap<>();
        List<device> device = deviceService.list();
        response.put("success", true);
        response.put("data", device);
        response.put("total", device.size());
        return ResponseEntity.ok(response);
    }

    /**
     * 删除设备
     */
    @DeleteMapping("/delete_device")
    public ResponseEntity<Map<String, Object>> DeleteDevice(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        int success = deviceService.DeleteDevice(id);
        if (success==1) {
            response.put("success", true);
            response.put("message", "设备删除成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "设备删除失败");
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 根据设备类型查询设备
     */
    @GetMapping("/search_device_type/{device_type}")
    public ResponseEntity<Map<String, Object>> findByDevice_type(@PathVariable String device_type) {
        Map<String, Object> response = new HashMap<>();
        device device = deviceService.findByDevice_type(device_type);
        if (device != null) {
            response.put("success", true);
            response.put("data", device);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "设备不存在");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 根据设备状态查询设备
     */
    @GetMapping("/search_status/{status}")
    public ResponseEntity<Map<String, Object>> findByStatus(@PathVariable String status) {
        Map<String, Object> response = new HashMap<>();
        device device = deviceService.findByStatus(status);
        if (device != null) {
            response.put("success", true);
            response.put("data", device);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "设备不存在");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 更新设备状态
     */
    @PatchMapping("/update_status")
    public ResponseEntity<Map<String, Object>> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Map<String, Object> response = new HashMap<>();
        boolean success = deviceService.updateStatus(id, status);
        if (success) {
            response.put("success", true);
            response.put("message", "状态更新成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "状态更新失败");
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 更新设备最后活跃时间
     */
    @PatchMapping("/update_last_active_time")
    public ResponseEntity<Map<String, Object>> updateLast_active_time(@PathVariable Long id, @RequestParam LocalDate last_active_time) {
        Map<String, Object> response = new HashMap<>();
        boolean success = deviceService.updateLast_active_time(id, last_active_time);
        if (success) {
            response.put("success", true);
            response.put("message", "最后活跃时间更新成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "最后活跃时间更新失败");
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 更新设备已上传数据条数
     */
    @PatchMapping("/update_data_count")
    public ResponseEntity<Map<String, Object>> updateData_count(@PathVariable Long id, @RequestParam int data_count) {
        Map<String, Object> response = new HashMap<>();
        boolean success = deviceService.updateData_count(id, data_count);
        if (success) {
            response.put("success", true);
            response.put("message", "已上传数据条数更新成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "已上传数据条数更新失败");
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 不同设备类型的设备数量统计
     */
    @GetMapping("/count/{device_type}")
    public ResponseEntity<Map<String, Object>> countByDevicetype() {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> statistics = deviceService.countByDevicetype();
        response.put("success", true);
        response.put("data", statistics);
        return ResponseEntity.ok(response);
    }

    /**
     * 统计每种设备类型下，状态为 online 的设备数量
     */
    @GetMapping("/count/{device_type}/online")
    public ResponseEntity<Map<String, Object>> countByDevicetype_online() {
        Map<String, Object> response = new HashMap<>();
        List<Map<String, Object>> statistics = deviceService.countByDevicetype_online();
        response.put("success", true);
        response.put("data", statistics);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询最近7天内活跃（last_active_time）设备的平均 data_count
     */
    @GetMapping("/count/data_count/last_active_time<7")
    public ResponseEntity<Map<String, Object>> countLast7day_avg_Datacount() {
        Map<String, Object> response = new HashMap<>();
        int count = deviceService.countLast7day_avg_Datacount();
        response.put("success", true);
        response.put("data", count);
        return ResponseEntity.ok(response);
    }
} 