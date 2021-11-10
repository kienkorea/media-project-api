package com.example.mediaproject.db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006&"}, d2 = {"Lcom/example/mediaproject/db/entity/Board;", "", "()V", "commentCount", "", "getCommentCount", "()J", "setCommentCount", "(J)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "id", "getId", "setId", "likeCount", "getLikeCount", "setLikeCount", "title", "getTitle", "setTitle", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "user", "Lcom/example/mediaproject/db/entity/User;", "getUser", "()Lcom/example/mediaproject/db/entity/User;", "setUser", "(Lcom/example/mediaproject/db/entity/User;)V", "media-project-api"})
@javax.persistence.Entity
public final class Board {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private long id = -1L;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime updatedAt;
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    public com.example.mediaproject.db.entity.User user;
    public java.lang.String title;
    public java.lang.String content;
    private long likeCount = 0L;
    private long commentCount = 0L;
    
    public Board() {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime getUpdatedAt() {
        return null;
    }
    
    public final void setUpdatedAt(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.mediaproject.db.entity.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.entity.User p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final long getLikeCount() {
        return 0L;
    }
    
    public final void setLikeCount(long p0) {
    }
    
    public final long getCommentCount() {
        return 0L;
    }
    
    public final void setCommentCount(long p0) {
    }
}