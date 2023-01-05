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

        final String os = System.getProperty("os.name");

        if (os.contains("Linux") && !userPhotoSaveDir.startsWith(separator))
            userPhotoSaveDir = separator + userPhotoSaveDir;

        if (!userPhotoSaveDir.endsWith(separator))
            userPhotoSaveDir = userPhotoSaveDir + separator;

        // Linux: /foobar/
        // Windows: D:/foobar/
        return userPhotoSaveDir;
    }
}
