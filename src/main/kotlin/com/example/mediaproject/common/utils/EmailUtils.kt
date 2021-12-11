package com.example.mediaproject.common.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class EmailUtils {
}

private var pattern: Pattern? = null
private var matcher: Matcher? = null
private val EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$"

fun normalizeEmail(email: String): Boolean? {
    pattern = Pattern.compile(EMAIL_REGEX)
    pattern.let { matcher = it?.matcher(email) }
    return matcher?.matches()
}