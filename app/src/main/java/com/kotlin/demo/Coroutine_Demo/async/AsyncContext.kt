package com.kotlin.demo.Coroutine_Demo.async

import android.util.Log
import com.kotlin.demo.Coroutine_Demo.log
import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * author： Created by shiming on 2018/3/20 11:53
 * mailbox：lamshiming@sina.com
 * ContinuationInterceptor使用的一个拦截器
 */
class AsyncContext:AbstractCoroutineContextElement(ContinuationInterceptor),ContinuationInterceptor{
    //串改 continuation
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        //fold 第一个是初始值，然后后面是一个lamd 表达式
        log("shiming 开始协程的地方  AsyncContext  aaa")
        return UiContinuationWrapper(continuation.context.fold(continuation){
            continuation,element->
            log("shiming 开始协程的地方  AsyncContext  bbb")
            //如果不是自己的话，是自己的话，就已经篡改过了的
            // 就不用拦截，同时这个元素是属于 这个拦截器的，不是自己 ，同时具有篡改机会
            if (element!=this&&element is ContinuationInterceptor){
                log("shiming 开始协程的地方  AsyncContext  element!=this")
                element.interceptContinuation(continuation)
            }else {
                log("shiming 开始协程的地方  AsyncContext  else")
                continuation
            }

        })
    }

}