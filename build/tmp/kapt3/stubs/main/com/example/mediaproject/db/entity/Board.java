package com.example.mediaproject.db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\"\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001c\u0010%\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b\'\u0010(R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006/"}, d2 = {"Lcom/example/mediaproject/db/entity/Board;", "", "()V", "commentList", "", "Lcom/example/mediaproject/db/entity/Comment;", "getCommentList", "()Ljava/util/List;", "setCommentList", "(Ljava/util/List;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "id", "", "getId", "()J", "setId", "(J)V", "isLiked", "", "()Z", "setLiked", "(Z)V", "likeCount", "getLikeCount", "setLikeCount", "title", "getTitle", "setTitle", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "user", "Lcom/example/mediaproject/db/entity/User;", "getUser", "()Lcom/example/mediaproject/db/entity/User;", "setUser", "(Lcom/example/mediaproject/db/entity/User;)V", "media-project-api"})
@javax.persistence.Entity
public final class Board {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private long id = -1L;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime updatedAt;
    public java.lang.String title;
    public java.lang.String content;
    private long likeCount = 0L;
    private boolean isLiked = false;
    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    public com.example.mediaproject.db.entity.User user;
    @org.jetbrains.annotations.NotNull
    @javax.persistence.OneToMany(mappedBy = "board", fetch = javax.persistence.FetchType.LAZY)
    private java.util.List<com.example.mediaproject.db.entity.Comment> commentList;
    
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
    
    public final boolean isLiked() {
        return false;
    }
    
    public final void setLiked(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.mediaproject.db.entity.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.entity.User p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.mediaproject.db.entity.Comment> getCommentList() {
        return null;
    }
    
    public final void setCommentList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.mediaproject.db.entity.Comment> p0) {
    }
}