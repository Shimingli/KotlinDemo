package com.kotlin.demo.compose_demo

/**
 * author： Created by shiming on 2018/3/9 14:19
 * mailbox：lamshiming@sina.com
 */
class ComposeDemoKt {
    init {
       println(multipplyBy2(add5(10))) //18*2
    }
}

val add5 = { i: Int -> i + 8 }
val multipplyBy2 = { i: Int -> 2 * i }