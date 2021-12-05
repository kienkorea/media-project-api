package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/mediaproject/api/service/UserServiceImpl;", "Lcom/example/mediaproject/api/service/UserService;", "userRepository", "Lcom/example/mediaproject/db/repository/UserRepository;", "boardRepository", "Lcom/example/mediaproject/db/repository/BoardRepository;", "(Lcom/example/mediaproject/db/repository/UserRepository;Lcom/example/mediaproject/db/repository/BoardRepository;)V", "changePassword", "Lcom/example/mediaproject/api/response/UserResponse;", "userId", "", "changePasswordRequest", "Lcom/example/mediaproject/api/request/ChangePasswordRequest;", "getAllMyBoard", "Lcom/example/mediaproject/api/response/UserAndBoardResponse;", "getMe", "resetPassword", "needChangePassword", "", "media-project-api"})
@org.springframework.stereotype.Service
public class UserServiceImpl implements com.example.mediaproject.api.service.UserService {
    private final com.example.mediaproject.db.repository.UserRepository userRepository = null;
    private final com.example.mediaproject.db.repository.BoardRepository boardRepository = null;
    
    public UserServiceImpl(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.BoardRepository boardRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.mediaproject.api.response.UserResponse getMe(long userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.mediaproject.api.response.UserAndBoardResponse getAllMyBoard(long userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    @javax.transaction.Transactional
    public com.example.mediaproject.api.response.UserResponse resetPassword(long userId, boolean needChangePassword) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    @javax.transaction.Transactional
    public com.example.mediaproject.api.response.UserResponse changePassword(long userId, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.ChangePasswordRequest changePasswordRequest) {
        return null;
    }
}