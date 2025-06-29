package com.example.mybatisdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisdemo.entity.user.User;

/**
 * 用户服务接口
 */
public interface UserService extends IService<User> {

    /**
     * 创建用户（包含业务验证）
     */
    boolean createUser(User user);

    /**
     * 修改密码
     */
    boolean updatePassword(User user);

    /**
     * 查询用户
     */
    User findByUsername(String username);

    /**
     * 根据用户名修改密码
     */
    boolean changePassword(String username, String password);

//    /**
//     * 查询最新创建的用户
//     */
//    User findLatestUser();
//
//    /**
//     * 查询用户总数
//     */
//    Long countUsers();
//
//    /**
//     * 根据条件查询用户
//     */
//    List<User> findByConditions(String username, String nickname, Integer gender);
//
//    /**
//     * 逻辑删除用户
//     */
//    boolean logicDelete(Long id);
//
//    /**
//     * 物理删除用户
//     */
//    boolean physicalDelete(Long id);
//
//    /**
//     * 根据用户名或手机号查询用户
//     */
//    User findByUsernameOrPhone(String account);
//
//    /**
//     * 获取用户统计信息
//     */
//    Map<String, Object> getUserStatistics();
} 