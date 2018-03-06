package com.kotlin.demo.fordemo

/**
 * author： Created by shiming on 2018/3/5 17:03
 * mailbox：lamshiming@sina.com
 */
//for 循环 .while 循环 continue break
class ForDemo{
    init {
        val array= arrayOf(1,5,8,96,6,2)
        println("循环  语句 start")
        for (i in array){
            println("$i="+i)
        }
        //也可以这样写
         for ((index,value) in array.withIndex()){
            println("$index  -> $value")
        }
        //也可以这样写哦
        for (int2 in array.withIndex()){
            println("${int2.index}->${int2.value}")
        }

        val list=MyList()
        list.add(1)
        list.add(1)
        list.add(1)

        for (i in list) {
         println("$i="+i)
        }

        var x=10
        while(x>0){
            println("X11="+x+" ")
            x--
        }
        do {
            println("X22="+x+" ")
            x--
        }while (x>0)

        val me=ArrayList<A>()
        val ou=A()
        for (oher in  me){
            if (ou==oher)continue  //跳过你的循环
            if (oher.isNot()){
                println("break in")
                break
            }
            println("wozai break de houmian ")
        }

    }
}
class A{
    fun isNot():Boolean{
        return false
    }
}

/**
 * for循环的背后的机制是  给任意类实现Iterator方法
 */
class MyIterator(var iterator: Iterator<Int>){
    operator fun next():Int{
        return iterator.next()
    }
    //operator是C++和pascal的关键字，它和运算符一起使用
    // ，表示一个运算符函数，理解时应将operator=整体上视为一个函数名
    operator fun hasNext():Boolean{
        return iterator.hasNext()
    }
}

class MyList{
    val list=ArrayList<Int>()

    fun add(int :Int){
        list.add(int)
    }

    fun remove(int :Int){
        list.remove(int)
    }

    operator fun iterator():MyIterator{
        return MyIterator(list.iterator())
    }
}