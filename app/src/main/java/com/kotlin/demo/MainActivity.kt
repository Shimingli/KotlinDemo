package com.kotlin.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val mBoolean:Boolean=true//相当于  开关

    val mFalseBoolean:Boolean=false
    val mInt:Int =8

    val mAnotherInt :Int=0XFF //表示一个十六进制的无符号的整数，十进制表示255
     val m2Int:Int =0b000000000011 //二进制 表示3
    val mMaxInt:Int=Int.MAX_VALUE
    val mMinInt:Int=Int.MIN_VALUE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //你好 kotlin
        println("Holle_Word")

        println("mIN"+mAnotherInt)
        println("m2Int"+m2Int)
        println("mMaxInt "+mMaxInt)
        println("mMinInt "+mMinInt)
    }
}
