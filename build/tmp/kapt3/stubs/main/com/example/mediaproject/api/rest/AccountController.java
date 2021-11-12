package com.example.mediaproject.api.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/mediaproject/api/rest/AccountController;", "", "userService", "Lcom/example/mediaproject/api/service/UserService;", "(Lcom/example/mediaproject/api/service/UserService;)V", "test", "", "model", "Lorg/springframework/ui/Model;", "media-project-api"})
@org.springframework.stereotype.Controller
@org.springframework.web.bind.annotation.RequestMapping(value = {"/media-project/up-down/accounts"})
public class AccountController {
    private final com.example.mediaproject.api.service.UserService userService = null;
    
    public AccountController(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.service.UserService userService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"/test"})
    public java.lang.String test(@org.jetbrains.annotations.NotNull
    org.springframework.ui.Model model) {
        return null;
    }
}