package com.kotlin.demo.compose_demo

import org.jetbrains.annotations.NotNull

/**
 * author： Created by shiming on 2018/3/9 14:19
 * mailbox：lamshiming@sina.com
 */
class ComposeDemoKt {
    init {
       println(multipplyBy2(add5(10))) //18*2
        val person: Person = Person("Jone", 20)
        person printName ("shiming")
        val function = add5 shiming multipplyBy2
        val function11 = add5 co  multipplyBy2
        println(function(10))  //36
        println(function11(10))  //28

        val function1 = add5new shiming multipplyBy2new

        println(function1("start"))  // 2start--woshinew--
    }
}
//为啥得到的是 28
//先 传入P1 10*2 =20  20+8 =28 根据  顺序来的  牛逼 可以的哦
infix fun <P1,P2,R> Function1<P2,R>.co(function: Function1<P1,P2>):Function1<P1,R>{
    return fun (p1:P1):R{
        return this.invoke(function.invoke(p1))
    }
}


//函数的复合  扩展Function1  infix 中缀表达式  P1=10 P2=18   Function0 .. Function22
//Function1<P1,P2>  p1参数的类型 ，p2表示返回值的类型
//function 传入的是 multipplyBy2，传入的是 P2 得到R
infix fun <P1,P2,R> Function1<P1,P2>.shiming(function: Function1<P2,R>):Function1<P1,R>{
    return fun (p1:P1):R{
        return function.invoke(this.invoke(p1))
    }
}

// 使用infix 关键字标记，该函数可被中缀标记法法调用
class Person(var name: String, var age: Int) {
    /**
    是成员函数, 或者是扩展函数
    只有单个参数
    使用 infix 关键字标记
     */
    infix fun printName(addr: String) {
        println("addr: $addr, name: $name")
    }
}
val add5 = { i: Int -> i + 8 }
val multipplyBy2 = { i: Int -> 2 * i }

val add5new = { i: String -> i + "--woshinew--" }
val multipplyBy2new = { i: String -> "2" + i }