package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.entity.user.User;
import com.example.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户控制器
 * 提供RESTful API接口
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = userService.createUser(user);
            if (success) {
                response.put("success", true);
                response.put("message", "用户创建成功");
                response.put("data", user);
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "用户创建失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (userService.findByUsername(user.getUsername()) != null && (userService.findByUsername(user.getUsername()).getPassword().equals(user.getPassword())) ){
                response.put("success", true);
                response.put("message", "登录成功");
                response.put("data", user);
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "登录失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * 修改密码
     */
    @PostMapping("/change-password")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (!Objects.equals(user.getPassword(), user.getConfirmPassword())) {
                response.put("success", false);
                response.put("message", "两次密码不一致");
                return ResponseEntity.badRequest().body(response);
            }
            boolean success = userService.updatePassword(user);
            if (success) {
                response.put("success", true);
                response.put("message", "密码修改成功");
                response.put("data", user);
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "密码修改失败");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

//    /**
//     * 根据ID查询用户
//     */
//    @GetMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Long id) {
//        Map<String, Object> response = new HashMap<>();
//        User user = userService.getById(id);
//        if (user != null) {
//            response.put("success", true);
//            response.put("data", user);
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("success", false);
//            response.put("message", "用户不存在");
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    /**
//     * 查询所有用户
//     */
//    @GetMapping
//    public ResponseEntity<Map<String, Object>> getAllUsers() {
//        Map<String, Object> response = new HashMap<>();
//        List<User> users = userService.list();
//        response.put("success", true);
//        response.put("data", users);
//        response.put("total", users.size());
//        return ResponseEntity.ok(response);
//    }
//
//    /**
//     * 删除用户（逻辑删除）
//     */
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
//        Map<String, Object> response = new HashMap<>();
//        boolean success = userService.logicDelete(id);
//        if (success) {
//            response.put("success", true);
//            response.put("message", "用户删除成功");
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("success", false);
//            response.put("message", "用户删除失败");
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//
//    /**
//     * 物理删除用户
//     */
//    @DeleteMapping("/{id}/physical")
//    public ResponseEntity<Map<String, Object>> physicalDeleteUser(@PathVariable Long id) {
//        Map<String, Object> response = new HashMap<>();
//        boolean success = userService.physicalDelete(id);
//        if (success) {
//            response.put("success", true);
//            response.put("message", "用户物理删除成功");
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("success", false);
//            response.put("message", "用户物理删除失败");
//            return ResponseEntity.badRequest().body(response);
//        }
//    }
//
//    /**
//     * 根据用户名查询用户
//     */
//    @GetMapping("/username/{username}")
//    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String username) {
//        Map<String, Object> response = new HashMap<>();
//        User user = userService.findByUsername(username);
//        if (user != null) {
//            response.put("success", true);
//            response.put("data", user);
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("success", false);
//            response.put("message", "用户不存在");
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    /**
//     * 条件查询用户
//     */
//    @GetMapping("/search")
//    public ResponseEntity<Map<String, Object>> searchUsers(
//            @RequestParam(required = false) String username,
//            @RequestParam(required = false) String nickname,
//            @RequestParam(required = false) Integer gender) {
//        Map<String, Object> response = new HashMap<>();
//        List<User> users = userService.findByConditions(username, nickname, gender);
//        response.put("success", true);
//        response.put("data", users);
//        response.put("total", users.size());
//        return ResponseEntity.ok(response);
//    }
//
//    /**
//     * 获取用户统计信息
//     */
//    @GetMapping("/statistics")
//    public ResponseEntity<Map<String, Object>> getUserStatistics() {
//        Map<String, Object> response = new HashMap<>();
//        Map<String, Object> statistics = userService.getUserStatistics();
//        response.put("success", true);
//        response.put("data", statistics);
//        return ResponseEntity.ok(response);
//    }
//
//    /**
//     * 获取最新创建的用户
//     */
//    @GetMapping("/latest")
//    public ResponseEntity<Map<String, Object>> getLatestUser() {
//        Map<String, Object> response = new HashMap<>();
//        User user = userService.findLatestUser();
//        if (user != null) {
//            response.put("success", true);
//            response.put("data", user);
//            return ResponseEntity.ok(response);
//        } else {
//            response.put("success", false);
//            response.put("message", "没有找到用户");
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    /**
//     * 获取用户总数
//     */
//    @GetMapping("/count")
//    public ResponseEntity<Map<String, Object>> getUserCount() {
//        Map<String, Object> response = new HashMap<>();
//        Long count = userService.countUsers();
//        response.put("success", true);
//        response.put("data", count);
//        return ResponseEntity.ok(response);
//    }
} 