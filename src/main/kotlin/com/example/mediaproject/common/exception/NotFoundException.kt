package com.example.mediaproject.common.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(errorMsg: String): RuntimeException(errorMsg) {
}