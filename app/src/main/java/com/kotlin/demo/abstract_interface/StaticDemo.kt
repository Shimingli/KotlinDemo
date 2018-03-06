package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 14:34
 * mailbox：lamshiming@sina.com
 */
//伴生对象和 静态成员  Math
class StaticDemo{
    init {
        val list= arrayListOf(1,5,4,7,8,4,8)
        val a= minOf(list.get(1).toInt(),list.get(0).toInt())
        val ofDouble = Latitude.ofDouble(3.25)
        val ofLatitude = Latitude.ofLatitude(ofDouble)
        //但是java中访问不到
        println(Latitude.TAG)

    }


}
class Latitude private constructor(val value:Double){
    companion object {
        @JvmStatic//这样 java中就可以直接调用了
        fun ofDouble(double: Double):Latitude{
            return Latitude(double)
        }

        fun ofLatitude(latitude: Latitude):Latitude{
            return Latitude(latitude.value)
        }
        @JvmField//在Java中 可以 访问了 加上这个标记
        val TAG:String="tag"
    }
}
