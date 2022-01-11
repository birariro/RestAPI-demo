package com.example.restapidemo.common.response.result.hader

enum class ErrorCode(var code: Int, var message: String) {
    UNKNOWN(-1,"-1"),
    TIME_OUT(-1,"-2"),
    DB(-1,"-3"),
    COMMUNICATION(-1,"-4"),
    CHAR_INVALID(-1,"-5"),
    HASH(-1,"-6"),
    PARAMETER_NAME_INVALID(-1,"-7"),
    VALUE_EMPTY(-1,"-8"),
    NOT_AUTHORIZED(-1,"-9")

}