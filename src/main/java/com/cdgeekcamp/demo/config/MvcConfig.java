package com.cdgeekcamp.demo.config;

import happyjava.HappyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@SuppressWarnings("unused")
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    private static final HappyLog log = new HappyLog(MvcConfig.class);

    @Autowired
    ApplicationConfig applicationConfig;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final String photoSavePath = applicationConfig.getUserPhotoSaveDir();
        File folder = new File(photoSavePath);

        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                log.error("无法创建用户头像保存目录（" + photoSavePath + "）");
                ctx.close();
            }
        }

        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:" + photoSavePath);
    }
}