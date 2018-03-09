package com.kotlin.demo.closure

/**
 * author： Created by shiming on 2018/3/9 11:35
 * mailbox：lamshiming@sina.com
 */
//闭包
class ClosureDemo{
    init {
        val makeFun = makeFun()
        makeFun()  //函数得作用域 有点大啊
        makeFun()  //下面也可以访问到 加载了以后的值啊
        makeFun()
        makeFun()
        val d = fibonacci()
        //这里 有个 很有趣的现象  ，如果 说我们直接打印的是方法名称的话 会输出 如下
        println(   fibonacci())
        println(   d())
        println(   d())
        println(   d())
        println(   d())
        println(   d())

        for (l in fibonacci2()) {
            if (l>100)break
            println(l)
        }
       println("这个有点意思 ")
        val add = add(5)
        println(add(2)) //5+2
        println(add)
    }
}

fun add(x:Int)=fun(y:Int)=x+y
//这个方法和上面的 方法是一直的哦  看着很启光
fun addnew(x:Int):(Int)->Int{

    //可以定义类  估计外面访问不到 哦
    data class Person(val name: String)

    return fun (y:Int) :Int{
        return x+y
    }
}

val string="HHHHH"
fun makeFun():()-> Unit {
    var count=0
    return fun (){
        println(++count)
    }
}

/**
 * 斐波那契数列指的是这样一个数列 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
 * 144, 233，377，610，987，1597，2584，4181，6765，10946，17711，28657，46368........
 *
 * 这个数列从第3项开始，每一项都等于前两项之和。
 */
fun fibonacci():()->Long{
    //这个函数得 作用域是 没有变的
    var first=0L
    var second=1L
    return  fun ():Long{
        val result=second //1  1  2  3
//        second+=first
        second=second+first //1 2 3 5
        first=second-first//1 1 2
        return result
    }
}

fun fibonacci2():Iterable<Long>{
    //这个函数得 作用域是 没有变的
    var first=0L
    var second=1L

    return Iterable {
        object :LongIterator(){
            override fun hasNext()=true

            override fun nextLong(): Long {
                val result=second //1  1  2  3
//        second+=first
                second=second+first //1 2 3 5
                first=second-first//1 1 2
                return result
            }

        }
    }
//    fun ():Long{
//        val result=second //1  1  2  3
////        second+=first
//        second=second+first //1 2 3 5
//        first=second-first//1 1 2
//        return result
//    }
}