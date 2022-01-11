package com.example.restapidemo.common.response.result.body

class HatroasResult<T> (
        val profile :String,
        val Links:List<T>
        ): CommonResult()


class HatroasDto(
        val rel:String,val href:String
)