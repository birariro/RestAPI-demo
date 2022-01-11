package com.example.restapidemo.common.response.result.body

class HatroasResult<T> (
        val data: T,
        val Links:List<HatroasDto>
        ): CommonResult()


class HatroasDto(
        val rel:String,val href:String
)