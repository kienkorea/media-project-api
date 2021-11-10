package com.example.mediaproject.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/mediaproject/config/QuerydslConfig;", "", "entityManager", "Ljavax/persistence/EntityManager;", "(Ljavax/persistence/EntityManager;)V", "jpqQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "media-project-api"})
@org.springframework.context.annotation.Configuration
public class QuerydslConfig {
    private final javax.persistence.EntityManager entityManager = null;
    
    public QuerydslConfig(@org.jetbrains.annotations.NotNull
    javax.persistence.EntityManager entityManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public com.querydsl.jpa.impl.JPAQueryFactory jpqQueryFactory() {
        return null;
    }
}