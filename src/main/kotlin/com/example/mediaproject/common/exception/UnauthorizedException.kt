package com.example.mediaproject.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException


@ResponseStatus(HttpStatus.UNAUTHORIZED)
class UnauthorizedException(errorMsg: String): RuntimeException(errorMsg) {
}