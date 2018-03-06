package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 11:41
 * mailbox：lamshiming@sina.com
 */

abstract class AA{
    open fun x():Int=5
}
interface BB{
    fun x():Int=11
}
interface CC{
    //当这里返回一个String,那的注意 不能一样
    fun x():Int=22
//    fun x():String =""
}
class DD(var y:Int=0):AA(),BB,CC {
    override fun x(): Int {
        println("方法一样 咋办")
        if (y>0){
            return y}
        else if (y<=-10&&y>-20){
            return super<BB>.x()
        }else if (y<=-20){
            return super<CC>.x()
        }else{
            return super<AA>.x()
        }

    }
}

