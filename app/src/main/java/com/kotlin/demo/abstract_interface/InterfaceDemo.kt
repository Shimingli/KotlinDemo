package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 10:28
 * mailbox：lamshiming@sina.com
 * 接口 抽象类
 */
interface InterfaceDemo{
    fun input(event:Any)
}
interface  A :InterfaceDemo
interface B :InterfaceDemo
class Aextend :A{
    init {
        input(this)
    }
    override fun input(event: Any) {
        println("我是类 实现了A")
    }
}
class Bextend :B{
    init {
        input(this)
    }
    override fun input(event: Any) {
        println("我是类 实现了B")
    }
}
class other:InterfaceDemo{
    init {
        input(this)
    }
    override fun input(event: Any) {
        println("我是类 实现了C")
    }
}
//和java是一样的，不用完全的实现这个的方法
abstract class D:InterfaceDemo
class C{
    init {
        val a=Aextend()
        val b=Bextend()
        val other=other()

        add(a)
        add(b)
        add(other)
    }
    fun doSomeThing(InterfaceDemo:A){
        println("doSomeThing：$InterfaceDemo ")
    }
    fun doSomeThingTwo(InterfaceDemo:B){
        println("doSomeThingTwo：$InterfaceDemo ")
    }

    /**
     * 注意when表达式的  使用的方式的  感觉是不是很吊啊
     * 哈哈  我是最牛逼的哦
     */
    fun add(InterfaceDemo:InterfaceDemo){
        when(InterfaceDemo){
            is A->{
                doSomeThing(InterfaceDemo)
            }
            is B->{
                doSomeThingTwo(InterfaceDemo)
            }
            else->{
                println("我什么都不知道！")
                val Me=Me(10)
                Me.work()
                val you=You()
                you.work()


                val driver=CarDriver()
                val writer=PPTWriter()
                //接口代理的Demo
                val seniorManager=SeniorManagerNew(driver,writer)
                seniorManager.writer()
                seniorManager.driver()

                println("方法一样了  咋办呢")
                println(DD(1).x())
                println(DD(-1).x())
                println(DD(-10).x())
                println(DD(-20).x())
            }
        }
    }
    abstract class BB{
        var i=0
        fun println(){

        }
    }

    interface DD{
        var j:Int
        //已经默认实现了 相当于接口中也有方法
        fun println(){

        }
    }
    //复写这个变量
    class DDDD(override var j: Int) :DD{

    }

    //单继承 多实现   大概是这个意思
}