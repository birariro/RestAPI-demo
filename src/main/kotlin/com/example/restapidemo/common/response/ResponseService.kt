package com.example.restapidemo.common.response

import com.example.restapidemo.common.response.result.body.*
import com.example.restapidemo.common.response.result.hader.ErrorCode
import com.example.restapidemo.common.response.result.hader.SuccessCode
import org.springframework.stereotype.Service

@Service
class ResponseService {

    //링크 를 반환하는 메소드
    fun <T> getHatroasResult(profile:String,list: List<T>): HatroasResult<T> {
        val result: HatroasResult<T> = HatroasResult(profile,list)
        setSuccessResult(result)
        return result
    }

    // 단일건 결과를 처리하는 메소드
    fun <T> getSingleResult(data: T): SingleResult<T> {
        val result: SingleResult<T> = SingleResult(data)
        setSuccessResult(result)
        return result
    }

    fun <T> getSingleResult(data: T, successCode: SuccessCode): SingleResult<T> {
        val result: SingleResult<T> = SingleResult(data)
        setSuccessResult(result, successCode)
        return result
    }

    // 다중건 결과를 처리하는 메소드
    fun <T> getListResult(list: List<T>): ListResult<T> {
        val result: ListResult<T> = ListResult(list)
        setSuccessResult(result)
        return result
    }

    fun <T> getListResult(list: List<T>, successCode: SuccessCode): ListResult<T> {
        val result: ListResult<T> = ListResult(list)
        setSuccessResult(result, successCode)
        return result
    }

    // 다중건 결과를 처리하는 메소드
    fun <T> getSetResult(set: Set<T>): SetResult<T> {
        val result: SetResult<T> = SetResult(set)
        setSuccessResult(result)
        return result
    }

    fun <T> getSetResult(set: Set<T>, successCode: SuccessCode): SetResult<T> {
        val result: SetResult<T> = SetResult(set)
        setSuccessResult(result, successCode)
        return result
    }

    // 실패 결과만 처리하는 메소드
    fun getFailResult(msg: String): CommonResult {
        return CommonResult(false, -1, msg)
    }

    fun getFailResult(code: Int, msg: String): CommonResult {
        return CommonResult(false, code, msg)
    }

    fun getFailResult(errorCode: ErrorCode): CommonResult {
        return getFailResult(errorCode.code, errorCode.message)
    }

    fun <T> getFailDataResult(errorCode: ErrorCode, data: T): SingleResult<T>? {
        val result: SingleResult<T> = SingleResult(data)
        setFailResult(errorCode, result)
        return result
    }

    private fun setFailResult(errorCode: ErrorCode, result: CommonResult) {
        result.success = false
        result.code = errorCode.code
        result.message = errorCode.message
    }

    // 성공 결과만 처리하는 메소드
    fun getSuccessResult(): CommonResult {
        val result = CommonResult()
        setSuccessResult(result)
        return result
    }

    fun getSuccessResult(successCode: SuccessCode): CommonResult {
        val result = CommonResult()
        setSuccessResult(result,successCode)
        return result
    }

    // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
    private fun setSuccessResult(result: CommonResult) {
        result.success = true
        result.code = SuccessCode.SUCCESS.code
        result.message = SuccessCode.SUCCESS.message
    }

    private fun setSuccessResult(result: CommonResult, successCode: SuccessCode) {
        result.success = true
        result.code = successCode.code
        result.message = successCode.message
    }

    // 문자열 결과만 처리하는 메서드
   // @Deprecated("")
    fun getStringResult(body: String): StringResult {
        val result = StringResult(body)
        setSuccessResult(result)
        return result
    }
}