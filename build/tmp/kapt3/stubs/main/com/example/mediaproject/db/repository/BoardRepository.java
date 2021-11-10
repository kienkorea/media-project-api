package com.example.mediaproject.db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/mediaproject/db/repository/BoardRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/mediaproject/db/entity/Board;", "", "existsBoardById", "", "boardId", "media-project-api"})
@org.springframework.stereotype.Repository
public abstract interface BoardRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.mediaproject.db.entity.Board, java.lang.Long> {
    
    public abstract boolean existsBoardById(long boardId);
}