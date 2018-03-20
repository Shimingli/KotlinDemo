package com.kotlin.demo.Coroutine_Demo.basic

import java.io.File
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * author： Created by shiming on 2018/3/19 16:59
 * mailbox：lamshiming@sina.com
 *
 * 协程的调度是应用层完成的，比如我们说 Lua 支持协程，
 * 那么各个协程如何运行，这一调度工作实际上是 Lua 自己的虚拟机来完成的。
 * 这个调度与线程调度有着比较大的差别，线程调度是抢占式调度，
 * 很有可能线程 A 运行得美滋滋的，线程 B 突然把 CPU 抢过来，跟 A 说“你给我下去吧你”，
 * 于是线程 A 只能干瞪眼没办法；而协程的调度是非抢占式的，
 * 目前常见的各种支持协程的语言实现中都有 yield 关键字，它有“妥协、退让”的意思，
 * 如果一个协程执行到一段代码需要歇会儿，
 * 那么它将把执行权让出来，如果它不这么做，没人跟它抢
 */
//对线程更熟悉一些。线程是比进程更小一级的运行单位，
// 它的调度由操作系统来完成，所以我们只管 new Thread 和 start，
// 至于什么时候 run，什么时候 run 完，我们都没办法预见。
//，CPU 在任意时刻运行什么进程及其线程，
// 是操作系统决定的，但归根结底一个单线程的 CPU 在任一时刻只能运行一个任务。
class BaseContinuation:Continuation<Unit>{
    /**
     * EmptyCoroutineContext 是一个空实现，没有任何功能，
     * 如果我们在使用协程时不需要上下文，那么我们就用这个对象作为一个占位即可
     */
    override val context: CoroutineContext
        get() =EmptyCoroutineContext

    /**
     * 一个是 resume，如果我们的程序没有任何异常，那么直接调用这个方法并传入需要返回的值；
     *
     */
    override fun resume(value: Unit) = Unit

    /**
     * 另一个是 resumeWithException，如果我们的程序出了异常，那我们可以通过调用这个方法把异常传递出去。
     */
    override fun resumeWithException(exception: Throwable) {
    }

}