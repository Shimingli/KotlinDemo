package com.kotlin.demo.star_demo

/**
 * author： Created by shiming on 2018/4/14 14:50
 * mailbox：lamshiming@sina.com
 */

class StartDemo{
    init {
        println("shiming 星投影 start")

        val list:List<*> = listOf(1,2,3)
        val any1 = list[1]

        val comparable: Comparable<*> = object:Comparable<Any>{
            override fun compareTo(other: Any): Int {
                return 0
            }

        }

      //  comparable.compareTo(any1)
        val mutableList:MutableList<*> = mutableListOf(1,1,2)
        val any = mutableList[1]

         val Mvp=Mvp()
    }
}