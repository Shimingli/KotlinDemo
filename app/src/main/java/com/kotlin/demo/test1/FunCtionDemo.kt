package com.kotlin.demo.test1

/**
 * author： Created by shiming on 2018/3/5 11:28
 * mailbox：lamshiming@sina.com
 */
//函数 得函数  得天下 返回值 相当于 Void
class FunCtionDemo{
    init {
        println("shiming    函数打印")
    }
   // 返回为int的类型的数据  等于说是秋后用
    fun sum(i: Int, i1: Int) :Int{
        return  i+i1
    }
    //变量 int2Long接这个值
    val int2Long=fun(x:Int):Long{
        return x.toLong()
    }
}
//其实是返回了  Unit
fun main(args: Array<String>):Unit {
    println("函数打印")
}