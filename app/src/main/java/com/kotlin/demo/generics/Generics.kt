package com.kotlin.demo.generics

import com.google.gson.Gson
import com.kotlin.demo.abstract_interface.D
import java.math.BigDecimal
import java.math.BigInteger
import javax.crypto.interfaces.PBEKey

/**
 * author： Created by shiming on 2018/4/16 11:10
 * mailbox：lamshiming@sina.com
 */
class Generics{
    init {
        val a=2
        val b=3
        val maxOf = maxOf(2, 3)
        println("shiming "+maxOf)

        val Complex1=Complex(4.0,5.0)
        val Complex2=Complex(5.0,6.0)
        println("shiming Complex1="+Complex1)
        println("shiming Complex2="+Complex2)
        println("shiming"+Complex1.compareTo(Complex2))
        println("shiming ------start")
        //定义一个集合，这样子就是多个泛型
        (1..2).map { println("shiming $it=="+it) }
        println("shiming ------start")

        val complexNumber1 = ComplexNumber<Int>(4, 5)
        val complexNumber2 = ComplexNumber(3.0, 4.5)

        getT<String>()
        getT<Double>()

        val person=Person("shiming",20)
        println("shiming  "+person)
        val toString = person.toString()
        val person1= Gson().fromJson<Person>(toString)
        println("shiming person1"+person1)

        //out 协变 Number 是Int的子类，协变点函数得返回类型
        val numberList11:List<Number> = listOf<Int>(1,58)
        //in 逆变 ，泛型的继承关系相反 逆变点就是函数参数的类型
        val intComparable11:Comparable<Int> = object :Comparable<Any>{
            override fun compareTo(other: Any): Int {
                return 0
            }
        }
        //不变的话，就根本没有继承关系，没有任何的关系
//        val list1:MutableList<Number> = mutableListOf<Int>(1,5,4)
//        val list2:MutableList<Int> = mutableListOf<Number>(1,5,4)
        val list311:MutableList<Int> = mutableListOf(1,5,4)


        //out 协变 Number 是Int的子类，协变点函数得返回类型
        val numberList:List<*> = listOf<Int>(1,58)
        val any = numberList[1] //星投影，去找父类
        //in 逆变 ，泛型的继承关系相反 逆变点就是函数参数的类型
        val intComparable:Comparable<*> = object :Comparable<Any>{
            override fun compareTo(other: Any): Int {
                return 0
            }
        }
        //星投影，去找父类 Nothing
//        intComparable.compareTo()

        //不变的话，就根本没有继承关系，没有任何的关系
//        val list1:MutableList<Number> = mutableListOf<Int>(1,5,4)
//        list1.add(BigDecimal(1244444444))
////        val list2:MutableList<Int> = mutableListOf<Number>(1,5,4)
//        val list3:MutableList<Int> = mutableListOf(1,5,4)

        //泛型的实参不要使用星号
//        val numberList11d:List<*> = listOf<*>(1,58)
//
//        hello<*>()
//
//        val hello: Any = Hello<*>()
         //这样也可以使用星投影
        val raw:Raw<*> = Raw.getRaw()

        /**
         * 星投影始终找最安全的解决方法
         * 协变和逆变：直接找他的父类
         *
         */
    }
}
fun <T> hello(){

}
open class Hello<T>{

}
//这样 就可以使用星投影
class Hello33<T>
//这样也可以使用星投影
class Hello2:Hello<Hello<*>>()
class Hello332:Hello<Hello33<*>>()



//inline inline可用内联函数(inline function)消除这些额外内存开销,
//说白了就是在调用处插入函数体代码,以此减少新建函数栈和对象的内存开销!
inline fun<reified T> getT(){
    println("shiming"+T::class.java)
}
//例子 通过inline把这个前面的代码植入到后面
// reified让泛型参数具体化，定义在inline中 ，kotlin实现为伪泛型，需要这个关键字植入到调用出才可以
inline fun <reified T> Gson.fromJson(json:String):T=fromJson(json,T::class.java)

data class Person(val name:String,val age:Int){
    //重写，得到json字符串
    override fun toString(): String {
        return "{name="+"\""+name+"\","+"age="+age+"}"
    }
}


// 需要有对比的功能，没有的话就会报错a<b
//加入限制 Comparable 具有对比的功能
fun<T:Comparable<T>> maxOf(a:T,b:T):T{
    return if (a<b) b else a
}
//泛型不管你到底是什么，它只管你能够做什么事情
data class Complex(val a:Double,val b:Double):Comparable<Complex>{
    override fun compareTo(other: Complex): Int {
        return (value()-other.value()).toInt()
    }
    fun value():Double{
        return a*a+b*b
    }

    override fun toString(): String {
        return "$a*$a+$b*$b="+(a*a+b*b)
    }
}
//泛型不管你到底是什么，它只管你能够做什么事情
data class ComplexNumber< T : Number>(val a:T,val b:T){


    override fun toString(): String {
        return "$a*$a+$b*$b"
    }
}
//按照重载的定义这两个方法应该编译的过的，但是Java和kotlin编译完了成了object或者是没有
fun needList(list:List<Double>){

}
//fun needList(list:List<Int>){
//
//}