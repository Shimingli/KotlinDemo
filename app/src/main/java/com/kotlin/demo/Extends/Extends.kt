package com.kotlin.demo.Extends

/**
 * author： Created by shiming on 2018/3/6 15:26
 * mailbox：lamshiming@sina.com
 */
class Extends{
    init {
        val string="dd"
        if (string.isEmpty()){

        }
        //abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc
        println("abc".multiply(16))//abc0=0abc1=1abc2=2abc3=3abc4=4abc5=5abc6=6abc7=7abc8=8abc9=9abc10=10abc11=11abc12=12abc13=13abc14=14abc15=15

       println("shiming".times(10))

        println("shiming"*10)

        println("s".a) //abc
        val b = "s".b  //5
        println(b)
    }
    //扩展方法
     fun String.multiply(int: Int):String{
        val StringBuffer=StringBuffer()
        for (i in 0 until int){ //从 0到 15  哈哈
            StringBuffer.append(this+"$i="+i)
        }
        return StringBuffer.toString()
    }

      operator fun String.times(int: Int):String{
        val StringBuffer=StringBuffer()
        for (i in 0 until int){ //从 0到 15  哈哈
            StringBuffer.append(this+"$i="+i)
        }
        return StringBuffer.toString()
    }
}
val String.a: String
    get() = "abc"

var String.b: Int
    set(value) {

    }
    get() = 5
