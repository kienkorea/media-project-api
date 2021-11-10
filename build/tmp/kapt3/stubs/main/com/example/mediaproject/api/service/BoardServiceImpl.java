package com.example.mediaproject.api.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/mediaproject/api/service/BoardServiceImpl;", "Lcom/example/mediaproject/api/service/BoardService;", "boardRepository", "Lcom/example/mediaproject/db/repository/BoardRepository;", "boardRepositorySupport", "Lcom/example/mediaproject/db/repository/BoardRepositorySupport;", "userRepository", "Lcom/example/mediaproject/db/repository/UserRepository;", "(Lcom/example/mediaproject/db/repository/BoardRepository;Lcom/example/mediaproject/db/repository/BoardRepositorySupport;Lcom/example/mediaproject/db/repository/UserRepository;)V", "deleteBoard", "", "boardId", "", "findAllBoard", "Lorg/springframework/data/domain/Page;", "Lcom/example/mediaproject/api/response/BoardResponse;", "pageable", "Lorg/springframework/data/domain/Pageable;", "q", "", "findBoardById", "patchBoard", "patchBoardRequest", "Lcom/example/mediaproject/api/request/PatchBoardRequest;", "postBoard", "postBoardRequest", "Lcom/example/mediaproject/api/request/PostBoardRequest;", "media-project-api"})
@org.springframework.stereotype.Service
public class BoardServiceImpl implements com.example.mediaproject.api.service.BoardService {
    private final com.example.mediaproject.db.repository.BoardRepository boardRepository = null;
    private final com.example.mediaproject.db.repository.BoardRepositorySupport boardRepositorySupport = null;
    private final com.example.mediaproject.db.repository.UserRepository userRepository = null;
    
    public BoardServiceImpl(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.BoardRepository boardRepository, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.BoardRepositorySupport boardRepositorySupport, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.repository.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    @javax.transaction.Transactional
    public com.example.mediaproject.api.response.BoardResponse postBoard(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.PostBoardRequest postBoardRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    @javax.transaction.Transactional
    public com.example.mediaproject.api.response.BoardResponse patchBoard(long boardId, @org.jetbrains.annotations.NotNull
    com.example.mediaproject.api.request.PatchBoardRequest patchBoardRequest) {
        return null;
    }
    
    @java.lang.Override
    public boolean deleteBoard(long boardId) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public com.example.mediaproject.api.response.BoardResponse findBoardById(long boardId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public org.springframework.data.domain.Page<com.example.mediaproject.api.response.BoardResponse> findAllBoard(@org.jetbrains.annotations.NotNull
    org.springframework.data.domain.Pageable pageable, @org.jetbrains.annotations.Nullable
    java.lang.String q) {
        return null;
    }
}