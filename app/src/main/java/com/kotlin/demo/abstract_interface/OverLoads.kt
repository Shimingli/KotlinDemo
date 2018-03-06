package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 14:48
 * mailbox：lamshiming@sina.com
 */
//方法重载  更方法重载 没毛关系

class OverLoads{

//    fun a():Int{
//        return 0
//    }
    @JvmOverloads  //加了这个标记 ，才能在Java中不传入 参数
    fun a(int: Int=0):Int{
        return int
    }
//    fun a(string: String):Int{
//        return string.length
//    }
//    fun a():String{
//        return "这样不行的哦"
//    }
}