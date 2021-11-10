package com.example.mediaproject.db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/example/mediaproject/db/entity/User;", "", "()V", "boardList", "", "Lcom/example/mediaproject/db/entity/Board;", "getBoardList", "()Ljava/util/List;", "setBoardList", "(Ljava/util/List;)V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "name", "getName", "setName", "password", "getPassword", "setPassword", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "userId", "getUserId", "setUserId", "media-project-api"})
@javax.persistence.Entity
public final class User {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private long id = -1L;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime updatedAt;
    public java.lang.String userId;
    public java.lang.String password;
    public java.lang.String name;
    public java.lang.String email;
    public java.lang.String phoneNumber;
    @org.jetbrains.annotations.NotNull
    @javax.persistence.OneToMany(mappedBy = "user", fetch = javax.persistence.FetchType.LAZY)
    private java.util.List<com.example.mediaproject.db.entity.Board> boardList;
    
    public User() {
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
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.mediaproject.db.entity.Board> getBoardList() {
        return null;
    }
    
    public final void setBoardList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.mediaproject.db.entity.Board> p0) {
    }
}