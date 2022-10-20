package com.project.hareexpress.application.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
public class BaseMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/static/*.css").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/*.js").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/*.png").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/src/*.png").addResourceLocations("classpath:/src/");
        registry.addResourceHandler("/js/*.js").addResourceLocations("classpath:/js/");
    }
}



