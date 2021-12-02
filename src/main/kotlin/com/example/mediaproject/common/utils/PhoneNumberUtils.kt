package com.example.mediaproject.common.utils

import com.example.mediaproject.common.exception.BadRequestException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
class PhoneNumberUtils {
}

fun normalizePhoneNumber(number: String): String {
    val logger: Logger = LoggerFactory.getLogger(PhoneNumberUtils::class.java)
    if (number.endsWith("@kongservice.com"))
        return number
    try {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val phoneNumber = phoneNumberUtil.parse(number, "KR")
        var normalizeNumber: String = phoneNumber.nationalNumber.toString()
        if (!normalizeNumber.startsWith("0")) normalizeNumber = "0$normalizeNumber"
        return normalizeNumber
    } catch (ex: NumberParseException) {
        logger.debug("{} is not numeric", number)
        throw BadRequestException("전화번호가 올바르지 않습니다. -> $number")
    } catch (ex: Exception) {
        ex.printStackTrace()
        throw BadRequestException("전화번호 파싱 중 에러가 발생했습니다. -> $number")
    }
}

fun maskPhoneNumber(phoneNumber: String): String {
    val builder: StringBuilder = StringBuilder(phoneNumber)
    val length = builder.length
    val maskingNumber = "*"
    var count = 0
    if (length < 4) {
        return builder.toString()
    }
    for (index in 3..length) {
        builder.replace(index, index + 1, maskingNumber)
        count++
        if (count == 4) {
            break
        }
    }
    return builder.toString()
}