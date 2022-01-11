package com.example.restapidemo.common.response.result.body

class SetResult<T>(
        val set:Set<T>
): CommonResult()
