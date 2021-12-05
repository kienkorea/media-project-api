package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/example/mediaproject/api/service/UserService;", "", "changePassword", "Lcom/example/mediaproject/api/response/UserResponse;", "userId", "", "changePasswordRequest", "Lcom/example/mediaproject/api/request/ChangePasswordRequest;", "getAllMyBoard", "Lcom/example/mediaproject/api/response/UserAndBoardResponse;", "getMe", "resetPassword", "needChangePassword", "", "media-project-api"})
@org.springframework.stereotype.Service
public abstract interface UserService {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserResponse getMe(long userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserAndBoardResponse getAllMyBoard(long userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserResponse resetPassword(long userId, boolean needChangePassword);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserResponse changePassword(long userId, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.ChangePasswordRequest changePasswordRequest);
}