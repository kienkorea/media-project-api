package com.example.mediaproject.common.utils

import com.example.mediaproject.api.response.TokenResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.collect.ImmutableMap
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ResponseBodySendUtils {
}

fun sendApiResponse(response: HttpServletResponse, tokenResponse: TokenResponse) {
    try {
        response.status = HttpStatus.OK.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "UTF-8"
        response.outputStream.write(ObjectMapper().writeValueAsString(tokenResponse).toByteArray())
    } catch (ex: java.lang.Exception) {
        ex.printStackTrace()
    }
}

fun sendError(request: HttpServletRequest, response: HttpServletResponse, ex: Exception, httpStatus: HttpStatus) {
    try {
        response.status = httpStatus.value()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "UTF-8"
        val data: Map<String, Any?> = ImmutableMap.of<String, Any?>(
            "timestamp", Calendar.getInstance().time,
            "status", httpStatus.value(),
            "error", ex.javaClass.simpleName,
            "message", ex.message ?: "No message",
            "path", request.requestURI
        )
        val pw = response.writer
        pw.print(ObjectMapper().writeValueAsString(data))
        pw.flush()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun sendError(request: HttpServletRequest, response: HttpServletResponse, ex: Exception) {
    sendError(request, response, ex, HttpStatus.UNAUTHORIZED)
}