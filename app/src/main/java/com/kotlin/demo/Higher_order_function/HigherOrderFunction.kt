package com.kotlin.demo.Higher_order_function

import kotlin.reflect.KFunction2

/**
 * author： Created by shiming on 2018/3/8 11:38
 * mailbox：lamshiming@sina.com
 */
class HigherOrderFunction{
    init {
        val array= arrayOf(1,25,8,4,5,55)
        //这就是高阶函数
        array.forEach(::println)
        val w=H::w
       // array.filter(:)
        //使用实例去调用 这个 prinln
        val pDFPrinter=PDFPrinter()
        array.forEach(pDFPrinter::println)
    }
}

//private fun <T> Array<T>.forEach(action: KFunction2<PDFPrinter, @ParameterName(name = "any") Any, Unit>) {
//
//}

class PDFPrinter{
    fun println(any: Any): Unit {
        kotlin.io.println("我是这个类的print的方法=="+any)
    }
}

class H{
    fun w(): Unit {
        println("woshi  ceshi")
    }
}