package com.example.mediaproject.api.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\tH\u0017J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\f\u001a\u00020\rH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/mediaproject/api/rest/UserController;", "", "userService", "Lcom/example/mediaproject/api/service/UserService;", "(Lcom/example/mediaproject/api/service/UserService;)V", "loginUser", "Lorg/springframework/http/ResponseEntity;", "Lcom/example/mediaproject/api/response/UserResponse;", "userId", "", "password", "registerUser", "postUserRequest", "Lcom/example/mediaproject/api/request/PostUserRequest;", "media-project-api"})
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = {"/media-project/up-down/users"})
public class UserController {
    private final com.example.mediaproject.api.service.UserService userService = null;
    
    public UserController(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.service.UserService userService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping(value = {"/register"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.UserResponse> registerUser(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.mediaproject.api.request.PostUserRequest postUserRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping(value = {"/login"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.UserResponse> loginUser(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam
    java.lang.String password) {
        return null;
    }
}