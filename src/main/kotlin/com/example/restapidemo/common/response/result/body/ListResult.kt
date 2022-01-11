package com.example.restapidemo.common.response.result.body

class ListResult<T>(
        val list:List<T>
) : CommonResult()
