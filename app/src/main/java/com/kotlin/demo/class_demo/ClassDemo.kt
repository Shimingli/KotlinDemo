package com.kotlin.demo.class_demo

/**
 * author： Created by shiming on 2018/3/5 14:48
 * mailbox：lamshiming@sina.com
 */
class Gril(var eag: String, var heigh: String, var face: String) {
    fun sing(sing: String) {
        println("$sing =" + sing)
        val a = A()
        println("我想获取 A的 值是多少"+a)
        println("" +
                "延迟初始化哦" +a.x1)
// 没有被初始化 所以 报错  UninitializedPropertyAccessException
        //println(a.c)


        println(a.cc?.length)
        //我告诉 虚拟器我不为null  但是我实际是null
        println(a.cc!!.length)//  at com.kotlin.demo.class_demo.Gril.sing(ClassDemo.kt:19)


    }
}

class A {
    protected var b = 0
        protected get() {
            return field
        }
        protected set
    //必须初始化 lateinit 延迟初始化
    lateinit var c: String
    //必须处理好，要不然
    lateinit var x: X
    //    val  是不能被更改的
//    var 能被更改的
    val x1: X by lazy {
        println("init X1")
        X()
    }

    var cc:String?=null
}

class X