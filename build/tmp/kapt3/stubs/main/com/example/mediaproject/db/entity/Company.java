package com.example.mediaproject.db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\u001f\u00a8\u0006 "}, d2 = {"Lcom/example/mediaproject/db/entity/Company;", "", "()V", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "hateCount", "", "getHateCount", "()J", "setHateCount", "(J)V", "id", "getId", "setId", "likeCount", "getLikeCount", "setLikeCount", "name", "getName", "setName", "updatedAt", "getUpdatedAt", "setUpdatedAt", "(Ljava/time/LocalDateTime;)V", "media-project-api"})
@javax.persistence.Entity
public final class Company {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private long id = -1L;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime updatedAt;
    public java.lang.String name;
    public java.lang.String email;
    private long likeCount = 0L;
    private long hateCount = 0L;
    
    public Company() {
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
    
    public final long getLikeCount() {
        return 0L;
    }
    
    public final void setLikeCount(long p0) {
    }
    
    public final long getHateCount() {
        return 0L;
    }
    
    public final void setHateCount(long p0) {
    }
}