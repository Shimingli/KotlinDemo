package com.kotlin.demo.Coroutine_Demo.sequence

import kotlin.coroutines.experimental.buildSequence

/**
 * author： Created by shiming on 2018/3/23 10:16
 * mailbox：lamshiming@sina.com
 * 序列生成器
 */
class SeqMain{
    init {
        println("shiming SeqMain")
        for (i in fibonacci){
            println("shiming fibonacci="+i)
            if (i>100) break
        }
    }
}
//也相当于一个协程的对象啊，这里比较牛逼啊
val fibonacci= buildSequence {
    yield(1)//每次这这里挂起了协程了
    var cur=1
    var next=1
    while (true){
        yield(next)
        val temp=cur+next
        cur=next
        next=temp
    }
}