package com.example.mediaproject.config

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.thymeleaf.templatemode.TemplateMode

@EnableWebMvc
@Configuration
class ApplicationWebConfig : WebMvcConfigurerAdapter(),
    ApplicationContextAware {

    private lateinit var applicationContext: ApplicationContext

    override fun setApplicationContext(applicationContext:
                                       ApplicationContext) {
        this.applicationContext = applicationContext
    }

    override fun addViewControllers(registry:
                                    ViewControllerRegistry) {
        super.addViewControllers(registry)

        registry.addViewController("/welcome.html")
    }
    @Bean
    fun templateResolver(): SpringResourceTemplateResolver {
        return SpringResourceTemplateResolver()
            .apply { prefix = "" }
            .apply { suffix = ".html"}
            .apply { templateMode = TemplateMode.HTML }
            .apply { setApplicationContext(applicationContext) }
    }

    @Bean
    fun templateEngine(): SpringTemplateEngine {
        return SpringTemplateEngine()
            .apply { setTemplateResolver(templateResolver()) }
    }

    @Bean
    fun viewResolver(): ThymeleafViewResolver {
        return ThymeleafViewResolver()
            .apply { templateEngine = templateEngine() }
            .apply { order = 1 }
    }


}