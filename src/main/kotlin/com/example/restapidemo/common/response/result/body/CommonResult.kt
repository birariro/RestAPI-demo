package com.example.restapidemo.common.response.result.body

open class CommonResult() {
    //성공 여부, 응답 코드, 응답 메시지
    var success: Boolean = true
    var code : Int = 0
    var message : String = "no message"

    constructor(success:Boolean, code:Int, message:String) : this() {
        this.code = code
        this.success = success
        this.message = message

    }
}