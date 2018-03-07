package com.kotlin.demo.Delegates

import kotlin.reflect.KProperty

/**
 * author： Created by shiming on 2018/3/6 16:18
 * mailbox：lamshiming@sina.com
 */
class Delegates{
    init {
        //代理
        val hello by lazy {
            "Hello"
        }
        val hello1 by X()

        val hello2 by X()

        var hello3 by X()//你如果需要可变的话,需要一个可写的方法

        println(hello)// Hello
        println(hello1)//getValue :null -> hello1
        println(hello2)//getValue :null -> hello2
        println(hello3)//getValue :null -> hello3
        hello3="value hello3"// setValue :null -> hello3 -> value hello3
        // 到这里 getValue :null -> hello3
        println(hello3)//value hello3
    }

}

class X{
    private var value:String?=null
     operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
         println("getValue :$thisRef -> ${property.name}")
        return value?:""
     }
    //需要这个方法的话 ，区别的是 上面的那个值 是val 还是var 的
    operator fun setValue(thisRef: Any?, property: KProperty<*>,value:String) {
        println("setValue :$thisRef -> ${property.name} -> $value")
        this.value=value
    }
}
