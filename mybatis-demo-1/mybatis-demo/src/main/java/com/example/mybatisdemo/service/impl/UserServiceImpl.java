package com.example.mybatisdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisdemo.entity.user.User;
import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 用户服务实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean createUser(User user) {
        // 业务验证
        if (!validateUser(user)) {
            return false;
        }

        // 检查用户名是否已存在
        if (findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("用户名已存在");
        }

        return save(user);
    }

    @Override
    public boolean updatePassword(User user) {

        // 检查用户是否已存在
        if (findByUsername(user.getUsername()) == null) {
            throw new RuntimeException("用户名有误");
        }

        // 检查密码是否合法
        if (!StringUtils.hasText(user.getPassword()) || user.getPassword().length() < 8 || user.getPassword().length() > 128) {
            throw new RuntimeException("密码长度必须在8-128个字符之间");
        }

        String password_regex = "^[A-Za-z0-9!@#$%^&*]+$";
        if (!user.getPassword().matches(password_regex)) {
            throw new RuntimeException("密码只能包含大写字母、小写字母、数字、!@#$%^&*");
        }

        return changePassword(user.getUsername(), user.getPassword());
    }

    @Override
    public User findByUsername(String username) {
        return baseMapper.findByUsername(username);
    }

    @Override
    public boolean changePassword(String username, String password) {
        return baseMapper.changePassword(username, password);}

    /**
     * 验证用户信息
     */
    private boolean validateUser(User user) {
        if (user == null) {
            return false;
        }

        // 验证用户名
        if (!StringUtils.hasText(user.getUsername()) || user.getUsername().length() < 3 || user.getUsername().length() > 50) {
            throw new RuntimeException("用户名长度必须在3-50个字符之间");
        }

        String regex = "^[a-z0-9_-]+$";
        if (!user.getUsername().matches(regex)){
            throw new RuntimeException("用户名只能包含小写字母（a-z）、数字（0-9）、下划线（_）或连字符（-）");
        }

        // 验证密码
        if (!StringUtils.hasText(user.getPassword()) || user.getPassword().length() < 8 || user.getPassword().length() > 128) {
            throw new RuntimeException("密码长度必须在8-128个字符之间");
        }

        String password_regex = "^[A-Za-z0-9!@#$%^&*]+$";
        if (!user.getPassword().matches(password_regex)) {
            throw new RuntimeException("密码只能包含大写字母、小写字母、数字、!@#$%^&*");
        }

        return true;
    }
//    @Override
//    public User findLatestUser() {
//        return baseMapper.findLatestUser();
//    }
//
//    @Override
//    public Long countUsers() {
//        return baseMapper.countUsers();
//    }
//
//    @Override
//    public List<User> findByConditions(String username, String nickname, Integer gender) {
//        return baseMapper.findByConditions(username, nickname, gender);
//    }
//
//    @Override
//    public boolean logicDelete(Long id) {
//        return baseMapper.logicDelete(id) > 0;
//    }
//
//    @Override
//    public boolean physicalDelete(Long id) {
//        return baseMapper.physicalDelete(id) > 0;
//    }
//
//    @Override
//    public User findByUsernameOrPhone(String account) {
//        return baseMapper.findByUsernameOrPhone(account);
//    }
//
//    @Override
//    public Map<String, Object> getUserStatistics() {
//        return baseMapper.getUserStatistics();
//    }
} 