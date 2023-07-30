package com.cdgeekcamp.shijianxing.config;

import io.github.happyjava.HappyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.annotation.Nonnull;
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
    public void addResourceHandlers(@Nonnull ResourceHandlerRegistry registry) {
        final String photoSavePath = applicationConfig.getUserPhotoSaveDir();
        File folder = new File(photoSavePath);

        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                log.error("无法创建用户头像保存目录（" + photoSavePath + "）");
                ctx.close();
            }
        }

        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/thymeleaf/images/favicon.ico");

        registry.addResourceHandler("/images/**")
                .addResourceLocations("classpath:/thymeleaf/images/", "file:" + photoSavePath);

        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/thymeleaf/css/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/thymeleaf/js/");
    }

    @Bean
    public ClassLoaderTemplateResolver customTemplateResolver() {
        ClassLoaderTemplateResolver customTemplateResolver = new ClassLoaderTemplateResolver();
        customTemplateResolver.setPrefix("thymeleaf/templates/");
        customTemplateResolver.setSuffix(".html");
        customTemplateResolver.setTemplateMode(TemplateMode.HTML);
        customTemplateResolver.setCharacterEncoding("UTF-8");
        customTemplateResolver.setOrder(1);
        customTemplateResolver.setCheckExistence(false);

        return customTemplateResolver;
    }
}