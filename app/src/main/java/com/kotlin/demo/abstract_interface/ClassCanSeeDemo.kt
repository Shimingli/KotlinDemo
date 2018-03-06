package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 14:14
 * mailbox：lamshiming@sina.com
 */
class ClassCanSeeDemo{
    init {
         val Countyard=Countyard()
        println("类的可见性")
        println(Countyard)
        val CanNoSee=CanNoSee()

    }
}
class House
class Flower

class Countyard{
    private val house=House()
    private val Flower=Flower()
}
//比较大的房子 房子  默认的是访问的权限是 public的 和java相反
class CanNoSee{
    //internal 模块内是可见得  internal还是尽量少用  真的
    internal val houses= arrayOf(House(),House(),House())
     val Flower=arrayOf(Flower(),Flower(),Flower())
}