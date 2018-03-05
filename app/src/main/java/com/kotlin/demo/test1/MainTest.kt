package com.kotlin.demo.test1

/**
 * author： Created by shiming on 2018/3/5 11:06
 * mailbox：lamshiming@sina.com
 */
//这个变量才相当于 我们编译器的常量  相当于 java中的 final的变量
const val FTEST="PTEST" //public final static Ljava/lang/String; FTEST = "PTEST"
class MainTest{
    init {
        println("变量")
    }
    //想当于 java中的final 不可变化 ，写入常量 减少犯错的可能性
    //但是不是编译期的常量
     val FINAL_HELLO_WORD:String="hello_word"
    val FINAL_HELLO_WORD_T="hello_word  ---"// 编译器 知道  ，你可以不用写 很聪明

    fun toTest1() {
        println("变量 to start this")
        println(FINAL_HELLO_WORD)

        val FINAL_HELLO_WORD:String="hello_word"

          val funCtionDemo:FunCtionDemo= FunCtionDemo()
        val sum = funCtionDemo.sum(1, 2)
        println("$sum="+(sum))
        //用变量去接函数得发放  匿名函数 赋值给一个变量
        val int2Long = funCtionDemo.int2Long(10)
        println(int2Long)
    }
}