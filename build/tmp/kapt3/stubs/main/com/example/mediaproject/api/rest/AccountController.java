package com.example.mediaproject.api.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0017J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/mediaproject/api/rest/AccountController;", "", "accountService", "Lcom/example/mediaproject/api/service/AccountService;", "(Lcom/example/mediaproject/api/service/AccountService;)V", "checkDuplicate", "Lorg/springframework/http/ResponseEntity;", "", "phoneNumber", "", "signIn", "Lcom/example/mediaproject/api/response/AccountResponse;", "httpResponse", "Ljavax/servlet/http/HttpServletResponse;", "signInRequest", "Lcom/example/mediaproject/api/request/SignInRequest;", "signUp", "signUpRequest", "Lcom/example/mediaproject/api/request/SignUpRequest;", "media-project-api"})
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = {"/media-project/up-down/accounts"})
public class AccountController {
    private final com.example.mediaproject.api.service.AccountService accountService = null;
    
    public AccountController(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.service.AccountService accountService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping(value = {"/sign-up"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.AccountResponse> signUp(@org.jetbrains.annotations.NotNull
    javax.servlet.http.HttpServletResponse httpResponse, @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.mediaproject.api.request.SignUpRequest signUpRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping(value = {"/sign-in"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.AccountResponse> signIn(@org.jetbrains.annotations.NotNull
    javax.servlet.http.HttpServletResponse httpResponse, @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.mediaproject.api.request.SignInRequest signInRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping(value = {"/check-duplicate"})
    public org.springframework.http.ResponseEntity<java.lang.Boolean> checkDuplicate(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam
    java.lang.String phoneNumber) {
        return null;
    }
}