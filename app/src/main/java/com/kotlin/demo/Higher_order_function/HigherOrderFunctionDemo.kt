package com.kotlin.demo.Higher_order_function

import java.util.ArrayList

/**
 * author： Created by shiming on 2018/3/8 14:35
 * mailbox：lamshiming@sina.com
 */
class HigherOrderFunctionDemo{
    init {
        println("高阶函数得Demo、")
        val lsit= listOf<Int>(1,5,4,86,985,482,47,54)

        val newList=ArrayList<Int>()

        lsit.forEach(){
            val i = it * 2 + 3
            newList.add(i)
        }
        //返回的是 unit
        newList.forEach(::println)

        //新的高阶函数 List
        val newlsit =lsit.map {
            it*2+3
        }
        //返回的是 unit
        newlsit.forEach(::println)

        //新的高阶函数 返回成一个Double
        val newlsit2 =lsit.map {
                it.toDouble()
        }
        //这个的写法和上面的 是一样的哦
        val newlist3=lsit.map(Int::toDouble)
        //返回的是 unit
        newlsit2.forEach(::println)
        println("newlist3 he newlist2的 方法的作用是一样的哦")
        newlist3.forEach(::println)

        lsit.map {
            println(it)
        }

        println("开始的地方 最牛逼")

        val list1= listOf(1..20,2..5)
        //吧上面的list1 转成
        //flatMap 把结合的
        // flatMap--合并两个集合，可以在合并的时候对迭代元素值it多想要的操作
        val newlist1=list1.flatMap { IntRange->
            IntRange.map { intE->
                "No,$intE"
            }

        }
        newlist1.forEach(::println)

        /**
        groupBy--将集合中的元素按照某个条件分组，返回Map；
        map--将集合中的元素通过某个方法转换后的结果存到一个集合中；
        mapIndexed--除了得到转换后的结果，还可以拿到index(下标)；
        mapNotNull--执行方法转换前过滤掉为null的元素；
         */
        val  flatList=list1.flatMap { it }
        //看里面的源码 ，里面是整数的和 1+2+3+4+5
        val reduce = (1..5).reduce { acc, i -> acc + i }
        println(reduce)
         val listn=(0..6).map(::factorial)//[1, 1, 2, 6, 24, 120, 720]
        println("listn++="+listn)
        listn.forEach(::println)

        val  newco=(1..5).fold(10){acc, i ->
            acc+i
        }
        println("$newco=="+newco) //1+2+3+4+5+5 当上面为5的时候  20==20
        println("$newco=="+newco) //1+2+3+4+5+10 当上面为10的时候 25==25


        val  newco2=(1..5).fold(StringBuffer()){acc, i ->
            acc.append(i).append(",")
        }
        println("$newco2=="+newco2) //1,2,3,4,5,==1,2,3,4,5,

        //0,1,2,3,4,5,6 字符串的连接
         println((0..6).joinToString (","))


        val newList11=(0..6).map(::factorial)//[1, 1, 2, 6, 24, 120, 720]
        val newList111=newList11.foldRight(StringBuffer()){i, acc ->
            acc.append(i).append(",")
        }
         //倒起来输入的哦  有点意思啊
         println(newList111) //720,120,24,6,2,1,1,

        println(newList11)  //[1, 1, 2, 6, 24, 120, 720]
        //过滤数据
        val dd=newList11.filter {
            it%2==1// 获取 是奇数的数据
        }
        println(dd)  //[1, 1]

        val ddd=newList11.filterIndexed { index, i -> index%2==1 }
        //获取奇数位置上的数据
        println(ddd) //[1, 6, 120]

        //不符合条件的数据 ，程序就终止了
        val ddddd=newList11.takeWhile { it%2==1 } //[1, 1]
        println(ddddd)


    }

    fun factorial(n:Int): Int {
        if (n==0) return 1
        println("(1..$n).reduce{acc, i ->acc*i  }=="+(1..n).reduce{acc, i ->acc*i  })
        return (1..n).reduceT{acc, i ->acc*i  } //1*2*3...n 一起做乘法 处理

    }
}
public inline fun <S, T: S> Iterable<T>.reduceT(operation: (acc: S, T) -> S): S {
    val iterator = this.iterator()
    if (!iterator.hasNext()) throw UnsupportedOperationException("Empty collection can't be reduced.")
    var accumulator: S = iterator.next()
    println("shiming $accumulator==="+accumulator)
    while (iterator.hasNext()) {
       // accumulator = operation(accumulator, iterator.next())
        //反编译 就是以下的代码  我都不知道 哪里错了
        accumulator = operation.invoke(accumulator, iterator.next())
    }
    return accumulator
}