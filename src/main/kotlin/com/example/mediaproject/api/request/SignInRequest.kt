package com.example.mediaproject.api.request

import io.swagger.annotations.ApiModelProperty

class SignInRequest (
    @ApiModelProperty(value = "휴대폰 번호")
    var phoneNumber: String,

    @ApiModelProperty(value = "비밀번호")
    var loginPassWord: String,
)
