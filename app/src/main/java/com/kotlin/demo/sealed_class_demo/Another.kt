package com.kotlin.demo.sealed_class_demo

/**
 * author： Created by shiming on 2018/3/7 19:45
 * mailbox：lamshiming@sina.com
 */
//可以 有很多个实例
//密封类是类的一种，用sealed修饰，不能用作基类。主要用于防止派生。
sealed class Another {
    class AAA(val a: String, val p: Long = 0) : Another()
    class BBB(val a: String) : Another()
    object PP : Another()
    object PPP : Another()
    object PPPP : Another()
}

enum class PPP {
    STOP, SPLY
}