//package com.example.mediaproject.config
//
//import org.springframework.context.ApplicationContext
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.web.servlet.config.annotation.EnableWebMvc
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//import org.springframework.web.servlet.view.InternalResourceViewResolver
//import org.springframework.web.servlet.view.JstlView
//import org.thymeleaf.spring5.SpringTemplateEngine
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
//import org.thymeleaf.spring5.view.ThymeleafViewResolver
//import org.thymeleaf.templatemode.TemplateMode
//import javax.annotation.Resource
//
//
//@Configuration
//@EnableWebMvc
//class ViewConfiguration : WebMvcConfigurer {
//
//    @Resource
//    protected var applicationContext: ApplicationContext? = null
//
//    @Resource
//    protected var springTemplateEngine: SpringTemplateEngine? = null
//
//    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
//        registry.addResourceHandler("/template/**").addResourceLocations("/template/")
////        registry.addResourceHandler("/images/**").addResourceLocations("/images/")
////        registry.addResourceHandler("/css/**").addResourceLocations("/css/")
////        registry.addResourceHandler("/js/**").addResourceLocations("/js/")
//    }
//
//    override fun configureViewResolvers(registry: ViewResolverRegistry) {
//        val resolver = InternalResourceViewResolver()
//        resolver.setPrefix("/WEB-INF/views/")
//        resolver.setSuffix(".jsp")
//        registry.viewResolver(resolver)
//    }
//}
///*
//    @Bean
//    fun thymeleafViewResolver(): ThymeleafViewResolver {
//        val viewResolver = ThymeleafViewResolver()
//        viewResolver.viewNames = arrayOf("thyme/*")
//        viewResolver.excludedViewNames = arrayOf("jsp/*")
//        viewResolver.templateEngine = springTemplateEngine
//        viewResolver.characterEncoding = "UTF-8"
//        return viewResolver
//    }
//
//    @Bean
//    fun jspViewResolver(): InternalResourceViewResolver {
//        val viewResolver = InternalResourceViewResolver()
//        viewResolver.setViewClass(JstlView::class.java)
//        viewResolver.setPrefix("/WEB-INF/views/")
//        viewResolver.setSuffix(".jsp")
//        return viewResolver
//    }
//
//    @Bean
//    fun thymeleafTemplateResolver(): SpringResourceTemplateResolver {
//        val templateResolver = SpringResourceTemplateResolver()
//        templateResolver.setApplicationContext(applicationContext!!)
//        templateResolver.prefix = "/WEB-INF/views/"
//        templateResolver.suffix = ".html"
//        templateResolver.templateMode = TemplateMode.HTML
//        templateResolver.isCacheable = false
//        templateResolver.order = 0
//        return templateResolver
//    }
//
//    @Bean
//    fun jspTemplateResolver(): SpringResourceTemplateResolver {
//        val templateResolver = SpringResourceTemplateResolver()
//        templateResolver.setApplicationContext(applicationContext!!)
//        templateResolver.prefix = "/WEB-INF/views/"
//        templateResolver.suffix = ".jsp"
//        templateResolver.templateMode = TemplateMode.HTML
//        templateResolver.isCacheable = false
//        templateResolver.order = 1
//        templateResolver.characterEncoding = "UTF-8"
//        return templateResolver
//    }
// */