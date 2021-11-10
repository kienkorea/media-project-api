package com.example.mediaproject.common.exception;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/mediaproject/common/exception/BadRequestException;", "Ljava/lang/RuntimeException;", "errorMsg", "", "(Ljava/lang/String;)V", "media-project-api"})
@org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
public final class BadRequestException extends java.lang.RuntimeException {
    
    public BadRequestException(@org.jetbrains.annotations.NotNull
    java.lang.String errorMsg) {
        super();
    }
}