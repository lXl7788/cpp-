package com.example.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.entity.device.device;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface DeviceMapper extends BaseMapper<device> {

    /**
     * 查询设备
     */
    @Select("SELECT * FROM device")
    device finddevice();

    /**
     * 根据设备类型查询设备
     */
    @Select("SELECT * FROM device WHERE device_type = #{device_type}")
    device findByDevice_type(@Param("device_type") String device_type);

    /**
     * 根据设备状态查询设备
     */
    @Select("SELECT * FROM device WHERE status = #{status}")
    device findByStatus(@Param("status") String status);

    /**
     * 更新设备状态
     */
    @Update("UPDATE device SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);

    /**
     * 更新设备最后活跃时间
     */
    @Update("UPDATE device SET last_active_time = #{last_active_time} WHERE id = #{id}")
    int updateLast_active_time(@Param("id") Long id, @Param("last_active_time") LocalDate last_active_time);

    /**
     * 更新设备已上传数据条数
     */
    @Update("UPDATE device SET data_count = #{data_count} WHERE id = #{id}")
    int updateData_count(@Param("id") Long id, @Param("data_count") int data_count);

    /**
     * 不同设备类型的设备数量统计
     */
    @Select("SELECT device_type, COUNT(*) as count FROM device GROUP BY device_type")
    List<Map<String, Object>> countByDevicetype();

    /**
     * 统计每种设备类型下，状态为 online 的设备数量
     */
    @Select("SELECT device_type, COUNT(*) as count FROM device WHERE status='online' GROUP BY device_type")
    List<Map<String, Object>> countByDevicetype_online();

    /**
     * 查询最近7天内活跃（last_active_time）设备的平均 data_count
     */
    @Select("SELECT data_count, AVG(*) as avg FROM device WHERE DATEDIFF(day,CURRENT_TIMESTAMP,last_active_time)<=7")
    int countLast7day_avg_Datacount();

    /**
     * 删除设备
     */
    @Delete("DELETE FROM device WHERE id = #{id}")
    int DeleteDevice(@Param("id") Long id);
}
