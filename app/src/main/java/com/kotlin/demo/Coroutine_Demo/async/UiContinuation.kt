package com.kotlin.demo.Coroutine_Demo.async

import java.io.File
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * author： Created by shiming on 2018/3/20 11:45
 * mailbox：lamshiming@sina.com
 * wrapper：包装一下，初始化的时候，给我一个continuation进来
 */
class UiContinuationWrapper<T>(val continuation:Continuation<T>):Continuation<T>{
    override val context: CoroutineContext
        get() = continuation.context //上下文的变量的联通  这里呢？得注意使用这里的context变量在哪里呢

    override fun resume(value: T) {
//        TODO() 这里切线程
        println("shiming 这里开始切换线程了resume" +value)
        continuation.resume(value)
    }

    override fun resumeWithException(exception: Throwable) {
        //        TODO() 这里切线程
        continuation.resumeWithException(exception)
    }

}