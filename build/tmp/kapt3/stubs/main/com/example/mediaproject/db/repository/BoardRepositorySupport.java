package com.example.mediaproject.db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/example/mediaproject/db/repository/BoardRepositorySupport;", "", "jpaQueryFactory", "Lcom/querydsl/jpa/impl/JPAQueryFactory;", "(Lcom/querydsl/jpa/impl/JPAQueryFactory;)V", "qBoard", "error/NonExistentClass", "Lerror/NonExistentClass;", "findAllBoardPaging", "Lorg/springframework/data/domain/Page;", "Lcom/example/mediaproject/db/entity/Board;", "pageable", "Lorg/springframework/data/domain/Pageable;", "q", "", "media-project-api"})
@org.springframework.stereotype.Repository
public class BoardRepositorySupport {
    private final com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory = null;
    private final error.NonExistentClass qBoard = null;
    
    public BoardRepositorySupport(@org.jetbrains.annotations.NotNull
    com.querydsl.jpa.impl.JPAQueryFactory jpaQueryFactory) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public org.springframework.data.domain.Page<com.example.mediaproject.db.entity.Board> findAllBoardPaging(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable, @org.jetbrains.annotations.Nullable
    java.lang.String q) {
        return null;
    }
}