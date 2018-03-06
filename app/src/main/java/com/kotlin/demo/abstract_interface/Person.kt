package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 10:58
 * mailbox：lamshiming@sina.com
 */
abstract class Person(open val age:Int){
    // 抽象类必须给我 open 哦
    //抽象方法哦
    abstract open fun work()
}
class Me( age: Int): Person(age){
    //重写变量
    override val age: Int
    get() = 0

    override fun work() {
        println("年龄"+age)
        println("我在工作")
    }
}
class You:Person(age = 10){
    override fun work() {
        println("年龄"+age)
        println("你是傻逼吧，哈哈")
    }
}