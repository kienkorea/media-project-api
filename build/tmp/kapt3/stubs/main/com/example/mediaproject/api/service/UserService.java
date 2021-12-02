package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/example/mediaproject/api/service/UserService;", "", "getAllMyBoard", "Lcom/example/mediaproject/api/response/UserAndBoardResponse;", "userId", "", "getMe", "Lcom/example/mediaproject/api/response/UserResponse;", "media-project-api"})
@org.springframework.stereotype.Service
public abstract interface UserService {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserResponse getMe(long userId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.UserAndBoardResponse getAllMyBoard(long userId);
}