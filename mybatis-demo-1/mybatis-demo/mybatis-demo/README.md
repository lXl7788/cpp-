# Spring Boot MyBatis 演示项目

这是一个基于 Spring Boot 3.5.3 和 MyBatis Plus 3.5.3.1 的用户管理系统演示项目，使用注解和SQL明文方式实现CRUD操作。

## 技术栈

- **Spring Boot**: 3.5.3
- **MyBatis Plus**: 3.5.3.1
- **MySQL**: 8.0.32
- **Java**: 17
- **Maven**: 构建工具

## 项目结构

```
mybatis-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/mybatisdemo/
│   │   │       ├── config/
│   │   │       │   └── MybatisPlusConfig.java
│   │   │       ├── controller/
│   │   │       │   └── UserController.java
│   │   │       ├── entity/
│   │   │       │   └── User.java
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── mapper/
│   │   │       │   └── UserMapper.java
│   │   │       ├── service/
│   │   │       │   ├── UserService.java
│   │   │       │   └── impl/
│   │   │       │       └── UserServiceImpl.java
│   │   │       └── MybatisDemoApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── db/
│   │           ├── schema.sql
│   │           └── data.sql
│   └── test/
└── pom.xml
```

## 数据库设计

### 用户表 (user)

| 字段名 | 类型 | 说明 |
|--------|------|------|
| id | BIGINT | 主键ID，自增 |
| username | VARCHAR(50) | 用户名，唯一 |
| phone | VARCHAR(20) | 手机号，唯一 |
| nickname | VARCHAR(100) | 昵称 |
| birth_date | DATE | 出生日期 |
| gender | TINYINT | 性别：0-未知，1-男，2-女 |
| create_time | DATETIME | 创建时间 |
| update_time | DATETIME | 更新时间 |
| deleted | TINYINT | 逻辑删除标志：0-未删除，1-已删除 |

## 功能特性

### 1. 基础CRUD操作
- ✅ 创建用户
- ✅ 查询用户（单个、列表、分页）
- ✅ 更新用户信息
- ✅ 删除用户（逻辑删除、物理删除）

### 2. 高级查询功能
- ✅ 根据用户名查询
- ✅ 根据手机号查询
- ✅ 根据性别查询
- ✅ 根据出生日期范围查询
- ✅ 根据昵称模糊查询
- ✅ 条件组合查询

### 3. 批量操作
- ✅ 批量创建用户

### 4. 统计功能
- ✅ 用户总数统计
- ✅ 各性别用户数量统计
- ✅ 用户统计信息

### 5. 业务特性
- ✅ 数据验证
- ✅ 唯一性检查
- ✅ 逻辑删除
- ✅ 自动填充时间字段
- ✅ 全局异常处理

## 快速开始

### 1. 环境要求
- JDK 17+
- MySQL 8.0+
- Maven 3.6+

### 2. 数据库配置
1. 创建MySQL数据库
2. 修改 `application.yml` 中的数据库连接信息：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mybatis_demo?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true
    username: root
    password: 123456
```

### 3. 运行项目
```bash
# 克隆项目
git clone <repository-url>
cd mybatis-demo

# 编译项目
mvn clean compile

# 运行项目
mvn spring-boot:run
```

### 4. 访问应用
- 应用地址: http://localhost:8080
- API文档: http://localhost:8080/api/users

## API接口文档

### 基础CRUD接口

#### 1. 创建用户
```http
POST /api/users
Content-Type: application/json

{
  "username": "testuser",
  "phone": "13800138000",
  "nickname": "测试用户",
  "birthDate": "1990-01-01",
  "gender": 1
}
```

#### 2. 查询所有用户
```http
GET /api/users
```

#### 3. 根据ID查询用户
```http
GET /api/users/{id}
```

#### 4. 更新用户
```http
PUT /api/users/{id}
Content-Type: application/json

{
  "username": "updateduser",
  "phone": "13800138000",
  "nickname": "更新后的昵称",
  "birthDate": "1990-01-01",
  "gender": 1
}
```

#### 5. 删除用户（逻辑删除）
```http
DELETE /api/users/{id}
```

#### 6. 物理删除用户
```http
DELETE /api/users/{id}/physical
```

### 高级查询接口

#### 7. 根据用户名查询
```http
GET /api/users/username/{username}
```

#### 8. 根据手机号查询
```http
GET /api/users/phone/{phone}
```

#### 9. 根据性别查询
```http
GET /api/users/gender/{gender}
```

#### 10. 根据出生日期范围查询
```http
GET /api/users/birth-date?startDate=1990-01-01&endDate=2000-12-31
```

#### 11. 根据昵称模糊查询
```http
GET /api/users/nickname?nickname=张
```

#### 12. 条件查询
```http
GET /api/users/search?username=test&nickname=张&gender=1
```

### 批量操作接口

#### 13. 批量创建用户
```http
POST /api/users/batch
Content-Type: application/json

[
  {
    "username": "user1",
    "phone": "13800138001",
    "nickname": "用户1",
    "birthDate": "1990-01-01",
    "gender": 1
  },
  {
    "username": "user2",
    "phone": "13800138002",
    "nickname": "用户2",
    "birthDate": "1991-02-02",
    "gender": 2
  }
]
```

### 统计接口

#### 14. 获取用户统计信息
```http
GET /api/users/statistics
```

#### 15. 获取各性别用户数量统计
```http
GET /api/users/statistics/gender
```

#### 16. 获取最新创建的用户
```http
GET /api/users/latest
```

#### 17. 获取用户总数
```http
GET /api/users/count
```

### 部分更新接口

#### 18. 更新用户昵称
```http
PATCH /api/users/{id}/nickname?nickname=新昵称
```

#### 19. 更新用户手机号
```http
PATCH /api/users/{id}/phone?phone=13900139000
```

## 响应格式

所有API接口都返回统一的JSON格式：

```json
{
  "success": true,
  "message": "操作成功",
  "data": {
    // 具体数据
  },
  "total": 10
}
```

## 错误处理

当发生错误时，返回格式如下：

```json
{
  "success": false,
  "message": "错误信息",
  "error": "错误类型"
}
```

## 技术亮点

1. **注解+SQL明文方式**: 完全使用注解和SQL明文，无需XML配置
2. **MyBatis Plus集成**: 充分利用MyBatis Plus的便利功能
3. **逻辑删除**: 支持逻辑删除和物理删除
4. **自动填充**: 自动填充创建时间和更新时间
5. **数据验证**: 完善的数据验证和业务逻辑
6. **全局异常处理**: 统一的异常处理机制
7. **RESTful API**: 标准的RESTful API设计
8. **批量操作**: 支持批量插入等操作

## 注意事项

1. 确保MySQL服务已启动
2. 修改数据库连接配置
3. 项目使用Java 17，确保JDK版本正确
4. 首次运行会自动创建数据库表并插入测试数据

## 许可证

MIT License 