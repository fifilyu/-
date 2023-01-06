# spring-boot-security-thymeleaf-mysql-demo

## 介绍

Spring Boot + Spring Security + Thymeleaf + MySQL数据库的Spring Boot示例项目

本项目基于 [registration-login-spring-boot-security-thymeleaf](https://github.com/knowledgefactory4u/registration-login-spring-boot-security-thymeleaf) 。

## 支持功能

1. 用户注册
2. 用户登录
3. 用户注销
4. 随机用户头像
5. 显示登录时间
6. Redis HTTP Session

## 系统要求

* Java 11+
* MySQL 5.7+
* Redis 3.2+

## 测试运行

### 运行步骤

1. 在MySQL中创建测试数据库：`spring-boot-security-thymeleaf-mysql-demo`
2. 下载或克隆本项目
3. 进入项目目录：`cd spring-boot-security-thymeleaf-mysql-demo`
4. 准备默认程序配置文件，复制配置文件模板（*application.properties.sample*）为 *application.properties*：
   1. 配置文件模板：src/main/resources/application.properties.sample
   2. 默认配置文件：src/main/resources/application.properties
   3. 修改 *application.properties* 文件中的MySQL数据库和Redis连接参数
5. 准备默认日志配置文件，复制配置文件模板（*logback.xml.sample*）为 *logback.xml*：
   1. 配置文件模板：src/main/resources/logback.xml.sample
   2. 默认配置文件：src/main/resources/logback.xml
   3. 更新日志文件路径：`sed -i 's#/var/#var/' src/main/resources/logback.xml`
6. 运行项目：`mvn spring-boot:run`
7. 在浏览器中访问URL： http://localhost:8080

### 部署发布

### 操作一、Linux服务器

1. 在MySQL中创建生产数据库：`spring-boot-security-thymeleaf-mysql-demo`
2. 创建Jar文件存放目录：`mkdir -p /data/web/`

### 操作二、本地

1. 进入项目目录
2. 上传程序配置文件到服务器：`scp src/main/resources/application.properties.sample root@{服务器IP地址}:/data/web/application.properties`
3. 上传日志配置文件到服务器：`scp src/main/resources/logback.xml.sample root@{服务器IP地址}:/data/web/logback.xml`
4. 打包Jar文件：`mvn package`
5. 上传Jar文件到服务器：`scp target/spring-boot-security-thymeleaf-mysql-demo-0.0.1.jar root@{服务器IP地址}:/data/web/`

### 操作三、Linux服务器

1. 修改 */data/web/application.properties* 文件中的MySQL数据库和Redis连接参数
2. */data/web/logback.xml* 文件中的日志文件路径默认不修改
3. 测试运行 `java -Dspring.config.location=/data/web/application.properties -jar /data/web/spring-boot-security-thymeleaf-mysql-demo-0.0.1.jar`
4. 创建Java系统服务(`SysV init scripts` 或者 `systemd`)，如CentOS7配置后使用 `systemtcl start spring-boot-security-thymeleaf-mysql-demo` 启动
   1. 具体配置方式本文不详细说明，请参考相关教程
5. 配置系统防火墙，开放8080端口

### 操作四、本地访问

浏览器中访问URL： http://{服务器IP地址}:8080