package com.cdgeekcamp.shijianxing.config;

import happyjava.HappyLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

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
    public ClassLoaderTemplateResolver secondaryTemplateResolver() {
        ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
        secondaryTemplateResolver.setPrefix("thymeleaf/templates/");
        secondaryTemplateResolver.setSuffix(".html");
        secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
        secondaryTemplateResolver.setCharacterEncoding("UTF-8");
        secondaryTemplateResolver.setOrder(1);
        secondaryTemplateResolver.setCheckExistence(true);

        return secondaryTemplateResolver;
    }
}