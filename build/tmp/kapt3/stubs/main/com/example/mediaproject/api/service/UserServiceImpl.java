package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/mediaproject/api/service/UserServiceImpl;", "Lcom/example/mediaproject/api/service/UserService;", "userRepository", "Lcom/example/mediaproject/db/repository/UserRepository;", "(Lcom/example/mediaproject/db/repository/UserRepository;)V", "checkExistUserId", "", "userId", "", "loginUser", "Lcom/example/mediaproject/api/response/UserResponse;", "password", "registerUser", "postUserRequest", "Lcom/example/mediaproject/api/request/PostUserRequest;", "media-project-api"})
@org.springframework.stereotype.Service
public class UserServiceImpl implements com.example.mediaproject.api.service.UserService {
    private final com.example.mediaproject.db.repository.UserRepository userRepository = null;
    
    public UserServiceImpl(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    @javax.transaction.Transactional
    public com.example.mediaproject.api.response.UserResponse registerUser(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.PostUserRequest postUserRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.mediaproject.api.response.UserResponse loginUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
        return null;
    }
    
    private final boolean checkExistUserId(java.lang.String userId) {
        return false;
    }
}