package com.example.mediaproject.api.rest;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00062\b\b\u0001\u0010\r\u001a\u00020\u000e2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0017J\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0017H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/mediaproject/api/rest/BroadController;", "", "boardService", "Lcom/example/mediaproject/api/service/BoardService;", "(Lcom/example/mediaproject/api/service/BoardService;)V", "deleteBoard", "Lorg/springframework/http/ResponseEntity;", "", "boardId", "", "findAllBoard", "Lorg/springframework/data/domain/Page;", "Lcom/example/mediaproject/api/response/BoardResponse;", "pageable", "Lorg/springframework/data/domain/Pageable;", "q", "", "findBoardById", "patchBoard", "patchBoardRequest", "Lcom/example/mediaproject/api/request/PatchBoardRequest;", "postBoard", "postBoardRequest", "Lcom/example/mediaproject/api/request/PostBoardRequest;", "media-project-api"})
@org.springframework.web.bind.annotation.RestController
@org.springframework.web.bind.annotation.RequestMapping(value = {"/media-project/up-down/boards"})
public class BroadController {
    private final com.example.mediaproject.api.service.BoardService boardService = null;
    
    public BroadController(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.service.BoardService boardService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PostMapping
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.BoardResponse> postBoard(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.mediaproject.api.request.PostBoardRequest postBoardRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.PatchMapping(value = {"/{boardId}"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.BoardResponse> patchBoard(@org.springframework.web.bind.annotation.PathVariable(value = "boardId")
    long boardId, @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestBody
    com.example.mediaproject.api.request.PatchBoardRequest patchBoardRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.DeleteMapping(value = {"/{boardId}"})
    public org.springframework.http.ResponseEntity<java.lang.Boolean> deleteBoard(@org.springframework.web.bind.annotation.PathVariable(value = "boardId")
    long boardId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"/{boardId}"})
    public org.springframework.http.ResponseEntity<com.example.mediaproject.api.response.BoardResponse> findBoardById(@org.springframework.web.bind.annotation.PathVariable(value = "boardId")
    long boardId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @io.swagger.annotations.ApiImplicitParams(value = {@io.swagger.annotations.ApiImplicitParam(dataTypeClass = int.class, paramType = "query", value = "\ud398\uc774\uc9c0 \ub118\ubc84", defaultValue = "", name = "page"), @io.swagger.annotations.ApiImplicitParam(dataTypeClass = int.class, paramType = "query", value = "\ud398\uc774\uc9c0 \ud06c\uae30", defaultValue = "", name = "size"), @io.swagger.annotations.ApiImplicitParam(dataTypeClass = int.class, paramType = "query", value = "\uc815\ub82c", defaultValue = "", name = "sort")})
    @org.springframework.web.bind.annotation.GetMapping(value = {"/list"})
    public org.springframework.http.ResponseEntity<org.springframework.data.domain.Page<com.example.mediaproject.api.response.BoardResponse>> findAllBoard(@org.jetbrains.annotations.NotNull
    @springfox.documentation.annotations.ApiIgnore
    org.springframework.data.domain.Pageable pageable, @org.jetbrains.annotations.Nullable
    @org.springframework.web.bind.annotation.RequestParam(value = "q", required = false)
    java.lang.String q) {
        return null;
    }
}