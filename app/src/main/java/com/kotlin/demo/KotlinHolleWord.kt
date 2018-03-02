package com.kotlin.demo


/**
 * author： Created by shiming on 2018/3/1 14:39
 * mailbox：lamshiming@sina.com
 */

//一个构造方法，可以不要 constructor
open class TwoTwoBean constructor( var eag:String,var face:String,var voice:String){
    init {
        println("我的女朋友，她的特点:年级:$eag,面部:$face,声音:$voice")

        val parent:Parent=Child()
        if (parent is Child){
            //自动的转化了为了 Child 类 比较只能  smart 智能转换
            println(parent.getName())
        }

        val s:String?="hello"
        //下面的写法会报错
        //println(s.length)
        if (s is String){
            println(s.length)
        }
        //new 个对象
        val parent1:Parent=Parent()
        // 强转为 child的 会报错 ClassCastException
        //val child:Child?=parent1 as Child
        //如果不想抛出异常
        val child1:Child?=parent1 as? Child
         //null  null 得到的结果 是 null 强转不成功的话 ，直接得到的是0
        println("$child1"+child1)

        println("shiming   end" )
    }

    open class Parent (){

    }
    class Child : Parent() {
        init {
            getName()
        }

        /**
         * 麻痹  不兼容 java
         */
        public fun getName() {
            println("我是小孩的类的 名字的Name")
        }
    }
}
fun main(args: Array<String>) {
    println("Holle-Word")
}

