package com.kotlin.demo.Expression

/**
 * author： Created by shiming on 2018/3/5 16:33
 * mailbox：lamshiming@sina.com
 */
class WhenKtDemo{
    init {
        val x=5
        when(x){
            // 第一个执行了 就不会执行其他的
           // is Int-> println("$x==into this")

           // in 1..100 -> println("5 在100 里面")
            //不在里面的话，就会执行 输出语句  ，如果在的话 ，就不执行
            !in 1..4-> println("5 不在1到4里面")
        }
         //when和 if语句一样的 也有返回值，下面的意思是
        //但x=4的时候，返回为1 不然就返回为0
        val i = when {x == 4 -> 1
            else
            -> 0
        }
        println("$i="+i)
    }
}