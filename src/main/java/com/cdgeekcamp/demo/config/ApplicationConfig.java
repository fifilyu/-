package com.cdgeekcamp.demo.config;

import happyjava.HappyLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("unused")
@Configuration
public class ApplicationConfig {
    private static final HappyLog log = new HappyLog(MvcConfig.class);

    @Value("${application.config.user-photo-save-dir}")
    private String userPhotoSaveDir;

    public String getUserPhotoSaveDir() {
        final String separator = "/";

        // 尾部添加路径分隔符，表示一定是目录
        // Linux: foobar/ or /foobar/
        // Windows: D:/foobar/
        if (!userPhotoSaveDir.endsWith(separator))
            userPhotoSaveDir = userPhotoSaveDir + separator;

        return userPhotoSaveDir;
    }
}
