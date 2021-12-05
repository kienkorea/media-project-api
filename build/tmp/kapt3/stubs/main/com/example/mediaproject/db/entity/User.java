package com.example.mediaproject.db.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010<\u001a\f\u0012\u0006\b\u0001\u0012\u00020>\u0018\u00010=H\u0016J\n\u0010?\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010@\u001a\u00020\u0017H\u0016J\b\u0010A\u001a\u00020#H\u0016J\b\u0010B\u001a\u00020#H\u0016J\b\u0010C\u001a\u00020#H\u0016J\b\u0010D\u001a\u00020#H\u0016R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010*\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001a\u0010-\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001a\u00100\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001c\u00103\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0011\"\u0004\b5\u0010\u0015R\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\u00a8\u0006E"}, d2 = {"Lcom/example/mediaproject/db/entity/User;", "Lorg/springframework/security/core/userdetails/UserDetails;", "()V", "boardList", "", "Lcom/example/mediaproject/db/entity/Board;", "getBoardList", "()Ljava/util/List;", "setBoardList", "(Ljava/util/List;)V", "commentList", "Lcom/example/mediaproject/db/entity/Comment;", "getCommentList", "setCommentList", "createdAt", "Ljava/time/LocalDateTime;", "getCreatedAt", "()Ljava/time/LocalDateTime;", "deletedAt", "getDeletedAt", "setDeletedAt", "(Ljava/time/LocalDateTime;)V", "email", "", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "isDeleted", "", "()Z", "setDeleted", "(Z)V", "loginPassWord", "getLoginPassWord", "setLoginPassWord", "name", "getName", "setName", "needChangePassword", "getNeedChangePassword", "setNeedChangePassword", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "updatedAt", "getUpdatedAt", "setUpdatedAt", "userRole", "Lcom/example/mediaproject/db/enumerable/UserRole;", "getUserRole", "()Lcom/example/mediaproject/db/enumerable/UserRole;", "setUserRole", "(Lcom/example/mediaproject/db/enumerable/UserRole;)V", "getAuthorities", "", "Lorg/springframework/security/core/GrantedAuthority;", "getPassword", "getUsername", "isAccountNonExpired", "isAccountNonLocked", "isCredentialsNonExpired", "isEnabled", "media-project-api"})
@javax.persistence.Entity
public final class User implements org.springframework.security.core.userdetails.UserDetails {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    private long id = -1L;
    @org.jetbrains.annotations.NotNull
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime updatedAt;
    public java.lang.String loginPassWord;
    public java.lang.String name;
    public java.lang.String email;
    public java.lang.String phoneNumber;
    private boolean isDeleted = false;
    @org.jetbrains.annotations.Nullable
    private java.time.LocalDateTime deletedAt;
    @org.jetbrains.annotations.NotNull
    private com.example.mediaproject.db.enumerable.UserRole userRole = com.example.mediaproject.db.enumerable.UserRole.NONE;
    private boolean needChangePassword = false;
    @org.jetbrains.annotations.NotNull
    @javax.persistence.OneToMany(mappedBy = "user", fetch = javax.persistence.FetchType.LAZY)
    private java.util.List<com.example.mediaproject.db.entity.Board> boardList;
    @org.jetbrains.annotations.NotNull
    @javax.persistence.OneToMany(mappedBy = "user", fetch = javax.persistence.FetchType.LAZY)
    private java.util.List<com.example.mediaproject.db.entity.Comment> commentList;
    
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
    public final java.lang.String getLoginPassWord() {
        return null;
    }
    
    public final void setLoginPassWord(@org.jetbrains.annotations.NotNull
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
    
    public final boolean isDeleted() {
        return false;
    }
    
    public final void setDeleted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime getDeletedAt() {
        return null;
    }
    
    public final void setDeletedAt(@org.jetbrains.annotations.Nullable
    java.time.LocalDateTime p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.mediaproject.db.enumerable.UserRole getUserRole() {
        return null;
    }
    
    public final void setUserRole(@org.jetbrains.annotations.NotNull
    com.example.mediaproject.db.enumerable.UserRole p0) {
    }
    
    public final boolean getNeedChangePassword() {
        return false;
    }
    
    public final void setNeedChangePassword(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.mediaproject.db.entity.Board> getBoardList() {
        return null;
    }
    
    public final void setBoardList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.mediaproject.db.entity.Board> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.mediaproject.db.entity.Comment> getCommentList() {
        return null;
    }
    
    public final void setCommentList(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.mediaproject.db.entity.Comment> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.util.Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.String getPassword() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String getUsername() {
        return null;
    }
    
    @java.lang.Override
    public boolean isAccountNonExpired() {
        return false;
    }
    
    @java.lang.Override
    public boolean isAccountNonLocked() {
        return false;
    }
    
    @java.lang.Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    
    @java.lang.Override
    public boolean isEnabled() {
        return false;
    }
}