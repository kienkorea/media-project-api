package com.example.mediaproject.db.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/example/mediaproject/db/repository/UserRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lcom/example/mediaproject/db/entity/User;", "", "existsByUserId", "", "userId", "", "findByUserIdAndPassword", "Ljava/util/Optional;", "password", "media-project-api"})
@org.springframework.stereotype.Repository
public abstract interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<com.example.mediaproject.db.entity.User, java.lang.Long> {
    
    public abstract boolean existsByUserId(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.Optional<com.example.mediaproject.db.entity.User> findByUserIdAndPassword(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String password);
}