# API 测试文档

本文档提供了MyBatis演示项目的API测试用例，可以使用Postman、curl或其他HTTP客户端工具进行测试。

## 环境准备

1. 确保MySQL服务已启动
2. 启动Spring Boot应用程序
3. 应用程序运行在 http://localhost:8080

## 测试用例

### 1. 创建用户

**请求:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser001",
    "phone": "13800138001",
    "nickname": "测试用户001",
    "birthDate": "1990-01-15",
    "gender": 1
  }'
```

**预期响应:**
```json
{
  "success": true,
  "message": "用户创建成功",
  "data": {
    "id": 1,
    "username": "testuser001",
    "phone": "13800138001",
    "nickname": "测试用户001",
    "birthDate": "1990-01-15",
    "gender": 1,
    "createTime": "2024-01-01T10:00:00",
    "updateTime": "2024-01-01T10:00:00",
    "deleted": 0
  }
}
```

### 2. 查询所有用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "username": "zhangsan",
      "phone": "13800138001",
      "nickname": "张三",
      "birthDate": "1990-01-15",
      "gender": 1,
      "createTime": "2024-01-01T10:00:00",
      "updateTime": "2024-01-01T10:00:00",
      "deleted": 0
    }
  ],
  "total": 1
}
```

### 3. 根据ID查询用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/1
```

**预期响应:**
```json
{
  "success": true,
  "data": {
    "id": 1,
    "username": "zhangsan",
    "phone": "13800138001",
    "nickname": "张三",
    "birthDate": "1990-01-15",
    "gender": 1,
    "createTime": "2024-01-01T10:00:00",
    "updateTime": "2024-01-01T10:00:00",
    "deleted": 0
  }
}
```

### 4. 根据用户名查询用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/username/zhangsan
```

**预期响应:**
```json
{
  "success": true,
  "data": {
    "id": 1,
    "username": "zhangsan",
    "phone": "13800138001",
    "nickname": "张三",
    "birthDate": "1990-01-15",
    "gender": 1,
    "createTime": "2024-01-01T10:00:00",
    "updateTime": "2024-01-01T10:00:00",
    "deleted": 0
  }
}
```

### 5. 根据手机号查询用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/phone/13800138001
```

**预期响应:**
```json
{
  "success": true,
  "data": {
    "id": 1,
    "username": "zhangsan",
    "phone": "13800138001",
    "nickname": "张三",
    "birthDate": "1990-01-15",
    "gender": 1,
    "createTime": "2024-01-01T10:00:00",
    "updateTime": "2024-01-01T10:00:00",
    "deleted": 0
  }
}
```

### 6. 根据性别查询用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/gender/1
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "username": "zhangsan",
      "phone": "13800138001",
      "nickname": "张三",
      "birthDate": "1990-01-15",
      "gender": 1,
      "createTime": "2024-01-01T10:00:00",
      "updateTime": "2024-01-01T10:00:00",
      "deleted": 0
    }
  ],
  "total": 1
}
```

### 7. 根据出生日期范围查询用户

**请求:**
```bash
curl -X GET "http://localhost:8080/api/users/birth-date?startDate=1990-01-01&endDate=1995-12-31"
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "username": "zhangsan",
      "phone": "13800138001",
      "nickname": "张三",
      "birthDate": "1990-01-15",
      "gender": 1,
      "createTime": "2024-01-01T10:00:00",
      "updateTime": "2024-01-01T10:00:00",
      "deleted": 0
    }
  ],
  "total": 1
}
```

### 8. 根据昵称模糊查询用户

**请求:**
```bash
curl -X GET "http://localhost:8080/api/users/nickname?nickname=张"
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "username": "zhangsan",
      "phone": "13800138001",
      "nickname": "张三",
      "birthDate": "1990-01-15",
      "gender": 1,
      "createTime": "2024-01-01T10:00:00",
      "updateTime": "2024-01-01T10:00:00",
      "deleted": 0
    }
  ],
  "total": 1
}
```

### 9. 条件查询用户

**请求:**
```bash
curl -X GET "http://localhost:8080/api/users/search?username=zhang&nickname=张&gender=1"
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "id": 1,
      "username": "zhangsan",
      "phone": "13800138001",
      "nickname": "张三",
      "birthDate": "1990-01-15",
      "gender": 1,
      "createTime": "2024-01-01T10:00:00",
      "updateTime": "2024-01-01T10:00:00",
      "deleted": 0
    }
  ],
  "total": 1
}
```

### 10. 更新用户信息

**请求:**
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "username": "zhangsan_updated",
    "phone": "13800138001",
    "nickname": "张三_更新",
    "birthDate": "1990-01-15",
    "gender": 1
  }'
```

**预期响应:**
```json
{
  "success": true,
  "message": "用户更新成功",
  "data": {
    "id": 1,
    "username": "zhangsan_updated",
    "phone": "13800138001",
    "nickname": "张三_更新",
    "birthDate": "1990-01-15",
    "gender": 1,
    "createTime": "2024-01-01T10:00:00",
    "updateTime": "2024-01-01T10:30:00",
    "deleted": 0
  }
}
```

### 11. 更新用户昵称

**请求:**
```bash
curl -X PATCH "http://localhost:8080/api/users/1/nickname?nickname=新昵称"
```

**预期响应:**
```json
{
  "success": true,
  "message": "昵称更新成功"
}
```

### 12. 更新用户手机号

**请求:**
```bash
curl -X PATCH "http://localhost:8080/api/users/1/phone?phone=13900139000"
```

**预期响应:**
```json
{
  "success": true,
  "message": "手机号更新成功"
}
```

### 13. 批量创建用户

**请求:**
```bash
curl -X POST http://localhost:8080/api/users/batch \
  -H "Content-Type: application/json" \
  -d '[
    {
      "username": "user001",
      "phone": "13800138002",
      "nickname": "用户001",
      "birthDate": "1991-02-15",
      "gender": 1
    },
    {
      "username": "user002",
      "phone": "13800138003",
      "nickname": "用户002",
      "birthDate": "1992-03-20",
      "gender": 2
    }
  ]'
```

**预期响应:**
```json
{
  "success": true,
  "message": "批量创建用户成功",
  "data": [
    {
      "username": "user001",
      "phone": "13800138002",
      "nickname": "用户001",
      "birthDate": "1991-02-15",
      "gender": 1
    },
    {
      "username": "user002",
      "phone": "13800138003",
      "nickname": "用户002",
      "birthDate": "1992-03-20",
      "gender": 2
    }
  ]
}
```

### 14. 获取用户统计信息

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/statistics
```

**预期响应:**
```json
{
  "success": true,
  "data": {
    "total": 3,
    "maleCount": 2,
    "femaleCount": 1,
    "unknownCount": 0
  }
}
```

### 15. 获取各性别用户数量统计

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/statistics/gender
```

**预期响应:**
```json
{
  "success": true,
  "data": [
    {
      "gender": 1,
      "count": 2
    },
    {
      "gender": 2,
      "count": 1
    }
  ]
}
```

### 16. 获取最新创建的用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/latest
```

**预期响应:**
```json
{
  "success": true,
  "data": {
    "id": 3,
    "username": "user002",
    "phone": "13800138003",
    "nickname": "用户002",
    "birthDate": "1992-03-20",
    "gender": 2,
    "createTime": "2024-01-01T11:00:00",
    "updateTime": "2024-01-01T11:00:00",
    "deleted": 0
  }
}
```

### 17. 获取用户总数

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/count
```

**预期响应:**
```json
{
  "success": true,
  "data": 3
}
```

### 18. 删除用户（逻辑删除）

**请求:**
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

**预期响应:**
```json
{
  "success": true,
  "message": "用户删除成功"
}
```

### 19. 物理删除用户

**请求:**
```bash
curl -X DELETE http://localhost:8080/api/users/1/physical
```

**预期响应:**
```json
{
  "success": true,
  "message": "用户物理删除成功"
}
```

## 错误测试用例

### 1. 创建重复用户名

**请求:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "zhangsan",
    "phone": "13800138004",
    "nickname": "重复用户名",
    "birthDate": "1990-01-15",
    "gender": 1
  }'
```

**预期响应:**
```json
{
  "success": false,
  "message": "用户名已存在",
  "error": "RuntimeException"
}
```

### 2. 创建重复手机号

**请求:**
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "username": "newuser",
    "phone": "13800138001",
    "nickname": "重复手机号",
    "birthDate": "1990-01-15",
    "gender": 1
  }'
```

**预期响应:**
```json
{
  "success": false,
  "message": "手机号已存在",
  "error": "RuntimeException"
}
```

### 3. 查询不存在的用户

**请求:**
```bash
curl -X GET http://localhost:8080/api/users/999
```

**预期响应:**
```json
{
  "success": false,
  "message": "用户不存在"
}
```

## 测试注意事项

1. **数据清理**: 测试前确保数据库中有初始测试数据
2. **ID依赖**: 某些测试用例依赖于前面测试用例创建的数据ID
3. **唯一性**: 用户名和手机号必须唯一，重复测试时需要修改
4. **日期格式**: 日期参数使用ISO格式 (YYYY-MM-DD)
5. **性别值**: 0-未知，1-男，2-女

## 自动化测试

可以使用以下工具进行自动化测试：

1. **Postman**: 导入测试集合
2. **JMeter**: 性能测试
3. **RestAssured**: Java单元测试
4. **curl脚本**: 批量测试

## 性能测试建议

1. 测试并发用户创建
2. 测试大量数据查询性能
3. 测试批量操作性能
4. 监控数据库连接池使用情况 