# 实践星

## 介绍

Spring Boot（3.2.4） + Spring MVC + Spring Security + Thymeleaf + Redis + MySQL的Java示例性项目，用快速上手SpringBoot框架

本项目基于 [registration-login-spring-boot-security-thymeleaf](https://github.com/knowledgefactory4u/registration-login-spring-boot-security-thymeleaf) 。

## 支持功能

1. 用户注册
2. 用户登录
3. 用户注销
4. 随机用户头像
5. 显示登录时间
6. Redis HTTP Session
7. 自动创建数据库
8. 从SQL文件（`resources/schema.sql`）重建数据表（清除原有数据）

## 系统要求

* Java 17+
* MySQL 5.7+
* Redis 3.2+

## 测试运行

### 运行步骤

1. 下载或克隆实践星源代码
2. 切换至实践星目录：`cd shi-jian-xing`
3. 准备默认程序配置文件，复制配置文件模板（*application.properties.sample*）为 *application.properties*：
   1. 配置文件模板：src/main/resources/application.properties.sample
   2. 默认配置文件：src/main/resources/application.properties
   3. 修改 *application.properties* 文件中的MySQL数据库和Redis连接参数
4. 准备默认日志配置文件，复制配置文件模板（*logback.xml.sample*）为 *logback.xml*：
   1. 配置文件模板：src/main/resources/logback.xml.sample
   2. 默认配置文件：src/main/resources/logback.xml
   3. 更新日志文件路径：`sed -i 's#/var/#var/' src/main/resources/logback.xml`
5. 运行项目：`mvn spring-boot:run`
6. 在浏览器中访问URL： http://localhost:8080

### 部署发布

### 操作一、本地

1. 进入实践星源代码目录：`cd shi-jian-xing`
2. 上传程序配置文件到服务器：`scp src/main/resources/application.properties.sample root@{服务器IP地址}:/data/web/application.properties`
3. 上传日志配置文件到服务器：`scp src/main/resources/logback.xml.sample root@{服务器IP地址}:/data/web/logback.xml`
4. 打包Jar文件：`mvn package`
5. 上传Jar文件到服务器：`scp target/shi-jian-xing-0.0.1.jar root@{服务器IP地址}:/data/web/`

### 操作三、Linux服务器

1. 修改 */data/web/application.properties* 文件中的MySQL数据库和Redis连接参数
2. */data/web/logback.xml* 文件中的日志文件路径默认不修改
3. 测试运行 `java -Dspring.config.location=/data/web/application.properties -jar /data/web/shi-jian-xing-0.0.1.jar`
4. 创建Java系统服务(`SysV init scripts` 或者 `systemd`)，如CentOS7配置后使用 `systemctl start shi-jian-xing` 启动
   1. 具体配置方式本文不详细说明，请参考相关教程
5. 配置系统防火墙，开放8080端口

### 操作四、本地访问

浏览器中访问URL： http://{服务器IP地址}:8080