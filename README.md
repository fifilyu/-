# spring-boot-security-thymeleaf-mysql-demo

## 介绍

Spring Boot + Spring Security + Thymeleaf + MySQL数据库的Spring Boot示例项目

本项目基于 [registration-login-spring-boot-security-thymeleaf](https://github.com/knowledgefactory4u/registration-login-spring-boot-security-thymeleaf) 。

## 支持功能

1. 用户注册
2. 用户登录
3. 用户注销

## 系统要求

* Java 11+
* MySQL 5.7+
* Redis 3.2+

## 测试运行

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

### 部署发布

### 操作一、Linux服务器

1. 在MySQL中创建生产数据库：`spring-boot-security-thymeleaf-mysql-demo`
2. 创建Jar文件存放目录：`mkdir -p /data/web/`

### 操作二、本地

1. 进入项目目录
2. 上传配置文件到服务器：`scp src/main/resources/application.properties.sample root@{服务器IP地址}:/data/web/application.properties`
3. 打包Jar文件：`mvn package`
4. 上传Jar文件到服务器：`scp target/spring-boot-security-thymeleaf-mysql-demo-0.0.1-SNAPSHOT.jar root@{服务器IP地址}:/data/web/`

### 操作三、Linux服务器

1. 修改 */data/web/application.properties* 文件中的数据库和Redis连接参数
2. 测试运行 `java -Dspring.config.location=/data/web/application.properties -jar /data/web/spring-boot-security-thymeleaf-mysql-demo-0.0.1-SNAPSHOT.jar`
3. 创建Java系统服务(`SysV init scripts` 或者 `systemd`)，如CentOS7配置后使用 `systemtcl start spring-boot-security-thymeleaf-mysql-demo` 启动
   1. 具体配置方式本文不详细说明，请参考相关教程
4. 配置系统防火墙，开放8080端口

### 操作四、本地访问

浏览器中访问URL： http://{服务器IP地址}:8080