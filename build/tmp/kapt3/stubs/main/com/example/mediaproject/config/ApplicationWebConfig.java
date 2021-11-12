package com.example.mediaproject.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/mediaproject/config/ApplicationWebConfig;", "Lorg/springframework/web/servlet/config/annotation/WebMvcConfigurerAdapter;", "Lorg/springframework/context/ApplicationContextAware;", "()V", "applicationContext", "Lorg/springframework/context/ApplicationContext;", "addViewControllers", "", "registry", "Lorg/springframework/web/servlet/config/annotation/ViewControllerRegistry;", "setApplicationContext", "templateEngine", "Lorg/thymeleaf/spring5/SpringTemplateEngine;", "templateResolver", "Lorg/thymeleaf/spring5/templateresolver/SpringResourceTemplateResolver;", "viewResolver", "Lorg/thymeleaf/spring5/view/ThymeleafViewResolver;", "media-project-api"})
@org.springframework.context.annotation.Configuration
@org.springframework.web.servlet.config.annotation.EnableWebMvc
public class ApplicationWebConfig extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter implements org.springframework.context.ApplicationContextAware {
    private org.springframework.context.ApplicationContext applicationContext;
    
    public ApplicationWebConfig() {
        super();
    }
    
    @java.lang.Override
    public void setApplicationContext(@org.jetbrains.annotations.NotNull
    org.springframework.context.ApplicationContext applicationContext) {
    }
    
    @java.lang.Override
    public void addViewControllers(@org.jetbrains.annotations.NotNull
    org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver templateResolver() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.thymeleaf.spring5.SpringTemplateEngine templateEngine() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.thymeleaf.spring5.view.ThymeleafViewResolver viewResolver() {
        return null;
    }
}