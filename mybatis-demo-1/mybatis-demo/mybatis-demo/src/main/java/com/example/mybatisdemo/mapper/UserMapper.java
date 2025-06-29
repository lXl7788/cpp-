package com.example.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.entity.user.User;
import org.apache.ibatis.annotations.*;

/**
 * 用户Mapper接口
 * 使用注解和SQL明文方式实现CRUD操作
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

//    /**
//     * 查询用户身份
//     */
//    @Select("SELECT identity FROM user WHERE username = #{username}")
//    User findIdentity(@Param("username") String username);

    /**
     * 修改密码
     */
    @Update("UPDATE user SET password = #{password} WHERE username = #{username}")
    boolean changePassword(@Param("username") String username, @Param("password") String password);



//    /**
//     * 查询最新创建的用户
//     */
//    @Select("SELECT * FROM user WHERE deleted = 0 ORDER BY create_time DESC LIMIT 1")
//    User findLatestUser();
//
//    /**
//     * 查询用户总数
//     */
//    @Select("SELECT COUNT(*) FROM user WHERE deleted = 0")
//    Long countUsers();
//
//    /**
//     * 根据条件查询用户（动态SQL）
//     */
//    @Select("<script>" +
//            "SELECT * FROM user WHERE deleted = 0 " +
//            "<if test='username != null and username != \"\"'>" +
//            "AND username LIKE CONCAT('%', #{username}, '%') " +
//            "</if>" +
//            "ORDER BY create_time DESC" +
//            "</script>")
//    List<User> findByConditions(@Param("username") String username);
//    /**
//     * 逻辑删除用户
//     */
//    @Update("UPDATE user SET deleted = 1, update_time = NOW() WHERE id = #{id}")
//    int logicDelete(@Param("id") Long id);
//
//    /**
//     * 物理删除用户
//     */
//    @Delete("DELETE FROM user WHERE id = #{id}")
//    int physicalDelete(@Param("id") Long id);
//
//    /**
//     * 根据用户名和手机号查询用户（用于登录验证）
//     */
//    @Select("SELECT * FROM user WHERE (username = #{account} OR phone = #{account}) AND deleted = 0")
//    User findByUsernameOrPhone(@Param("account") String account);
} 