package com.kotlin.demo.operator


/**
 * author： Created by shiming on 2018/3/5 15:12
 * mailbox：lamshiming@sina.com
 */
//kotlin中的运算符号
class OperatorDemo(var real:Double,var real1: Double){
    init {

    }
    operator fun plus(other:OperatorDemo):OperatorDemo{

        return OperatorDemo(real+other.real,real1+other.real1)
    }
    operator fun plus(other: Any): Int {
        if (Book() on Desk()){//dsl
            println("shiming Desk")
        }
        println("shiming Desk"+(Book() on Desk()))
        return real.toInt()
    }

    override fun toString(): String {
        return "$real+$real1"
    }
}
class Book{
    //中缀表达式  不明白啊 真的不明白
    infix fun on(any:Any):Boolean{return false}
}
class Desk