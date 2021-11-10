package com.example.mediaproject.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
//            .securityContexts(Lists.newArrayList(securityContext()))
            .build()
//            .securitySchemes(Lists.newArrayList(apiKey()) as List<SecurityScheme>)
    }

    /*


    fun securityContext(): SecurityContext {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .build()
    }

    fun defaultAuth(): List<SecurityReference>? {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        return Lists.newArrayList(SecurityReference("JWT", authorizationScopes))
    }

    fun apiKey(): ApiKey {
        return ApiKey("JWT", "Authorization", "header")
    }

     */
}