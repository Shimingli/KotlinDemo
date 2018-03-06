package com.kotlin.demo.parameter_demo

/**
 * author： Created by shiming on 2018/3/6 09:45
 * mailbox：lamshiming@sina.com
 */
class ParameterDemo{
    init {
        val sum = sum(i1 = 10, i = 5)
        longT("shiming")

        longT1("shiming",i1 = 1)

        val array= intArrayOf(1,4,5,6)
        val list= arrayListOf<Int>(1,2,4)
        longT2(*array,i1 = 1)
        //只支持数组 array，不支持集合 list
       // longT2(*list,i1 = 1)
        //默认参数
        val sumT = sumT(i1 = 2)
        println(sumT)
        sumTEnd(1)//如果默认参数在最有的一个位置的话，这样传入的也是没有问题的哦
    }
    //默认参数，在比较靠前的位置的话吗，那么后面只能使用具名参数了
    fun sumT(i:Int=10,i1:Int):Int{
        println("默认参数 $i+$i1="+(i+i1))
        return i+i1
    }
    fun sumTEnd(i:Int,i1:Int=102):Int{
        println("默认参数 $i+$i1="+(i+i1))
        return i+i1
    }
    fun sum(i:Int,i1:Int):Int{
        println("具名参数 $i+$i1="+(i+i1))
        return i+i1
    }

    fun longT(vararg string: String){
       println("变成参数"+string)

        string.forEach(::println)//shiming
    }
    //变长参数，可以在任意的文字
    fun longT1(vararg string: String,i1: Int){
        println("变成参数"+string)

        string.forEach(::println)//shiming
    }
    fun longT2(vararg string: Int,  i1: Int){
        println("变成参数"+string)

        string.forEach(::println)//shiming
    }
}