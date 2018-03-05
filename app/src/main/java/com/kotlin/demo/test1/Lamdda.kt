package com.kotlin.demo.test1

/**
 * author： Created by shiming on 2018/3/5 11:54
 * mailbox：lamshiming@sina.com
 * public inline fun <T> Iterable<T>.forEach(action: (T) -> Unit): Unit 最后的结尾是lamdda
 * 表达式 可以简写 如下的
 */


class Lamdda{
    init {
        //lamdda 表达式
        val sum={i:Int,i1:Int->i+i1}
        println("shiming lamdda"+sum(10,20))
        val sum2={i:Int,i1:Int-> println("shiming in this"+"$i+$i1=${i+i1}")
            i+i1}
        println("shiming lamdda 2==="+sum2(11,11))
        //和上面的一样哦
        println("shiming lamdda 2==="+sum2.invoke(11,11))
        val arrayInt: ArrayList<Int> = arrayListOf(1,1,2,4,4,5,8)
        //相当于 for循环
        arrayInt.forEach ({
            println(it)
        })
        //也可以这样写哦
        arrayInt.forEach ({shiming->
            println("$shiming=="+shiming)
        })
        //println 接受任何对象 都可以哦 这样写  估计是最简单的
        arrayInt.forEach (::println)
        //只要等于2的 话 就不能输出了哦
        arrayInt.forEach ForEach@{
            if (it==2)return@ForEach
            println("shimingdddd"+it)
        }
        arrayInt.forEach {
            if (it==2) return@forEach
            println("shimingdddd"+it)
        }

        println("The end")//（Any）->unit

        println(arrayInt)

        println(sum)// Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>
    }
}