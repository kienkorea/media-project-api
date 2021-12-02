package com.example.mediaproject.api.request

import io.swagger.annotations.ApiModelProperty

data class SignUpRequest(
    @ApiModelProperty(value = "휴대폰 번호")
    var phoneNumber: String,

    @ApiModelProperty(value = "비밀번호")
    var loginPassword: String,

    @ApiModelProperty(value = "이름")
    var name: String,

    @ApiModelProperty(value = "이메일")
    var email: String
)

