package com.kotlin.demo.Coroutine_Demo.async

import java.util.concurrent.Executors

/**
 * author： Created by shiming on 2018/3/19 18:50
 * mailbox：lamshiming@sina.com
 */
class AsynTask(val block:()->Unit){
    fun execute()= pool.execute(block)
}
//new的线程池，这个线程池是私有的，防止别人使用到
private val pool by lazy {
    Executors.newCachedThreadPool()
}