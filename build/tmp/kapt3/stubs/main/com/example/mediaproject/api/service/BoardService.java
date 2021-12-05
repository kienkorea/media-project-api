package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H&\u00a8\u0006\u001a"}, d2 = {"Lcom/example/mediaproject/api/service/BoardService;", "", "deleteBoard", "", "boardId", "", "findAllBoard", "Lorg/springframework/data/domain/Page;", "Lcom/example/mediaproject/api/response/BoardResponse;", "pageable", "Lorg/springframework/data/domain/Pageable;", "q", "", "findBoardById", "findBoardList", "", "getBoardDetail", "Lcom/example/mediaproject/api/response/BoardDetailResponse;", "patchBoard", "patchBoardRequest", "Lcom/example/mediaproject/api/request/PatchBoardRequest;", "patchLikeBoard", "isLiked", "postBoard", "postBoardRequest", "Lcom/example/mediaproject/api/request/PostBoardRequest;", "media-project-api"})
@org.springframework.stereotype.Service
public abstract interface BoardService {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.BoardResponse postBoard(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.PostBoardRequest postBoardRequest);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.BoardResponse patchBoard(long boardId, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.PatchBoardRequest patchBoardRequest);
    
    public abstract boolean deleteBoard(long boardId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.BoardResponse findBoardById(long boardId);
    
    @org.jetbrains.annotations.NotNull
    public abstract org.springframework.data.domain.Page<com.example.mediaproject.api.response.BoardResponse> findAllBoard(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable, @org.jetbrains.annotations.Nullable
    java.lang.String q);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.mediaproject.api.response.BoardResponse> findBoardList();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.BoardDetailResponse getBoardDetail(long boardId);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.mediaproject.api.response.BoardResponse patchLikeBoard(long boardId, boolean isLiked);
}