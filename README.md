# spring-boot-security-thymeleaf-mysql-demo

## 介绍

Spring Boot + Spring Security + Thymeleaf + MySQL数据库的Spring Boot示例项目

本项目基于 [registration-login-spring-boot-security-thymeleaf](https://github.com/knowledgefactory4u/registration-login-spring-boot-security-thymeleaf) 。

## 支持功能

1. 用户注册
2. 用户登录
3. 用户注销

## 运行项目

### 系统要求

* Java 11+
* MySQL 5.7+

### 运行步骤

1. 在MySQL中创建测试数据库：`spring-boot-security-thymeleaf-mysql-demo`
2. 下载或克隆本项目
3. 进入项目目录：`cd spring-boot-security-thymeleaf-mysql-demo`
4. 准备默认配置文件，复制配置文件模板（*application.properties.sample*）为 *application.properties*：
   1. 配置文件模板：src/main/resources/application.properties.sample
   2. 默认配置文件：src/main/resources/application.properties
   3. 修改 *application.properties* 文件中的MySQL用户名和用户密码
5. 运行项目：`mvn spring-boot:run`
6. 在浏览器中访问URL： http://localhost:8080