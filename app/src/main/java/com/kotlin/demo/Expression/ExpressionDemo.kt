package com.kotlin.demo.Expression



/**
 * author： Created by shiming on 2018/3/5 15:38
 * mailbox：lamshiming@sina.com
 *
 * 中缀表达式 :只有一个参数，且用 infix 修饰的函数
 * ，分支表达式，
 * when表达式
 */
const val USERNAME="kotlin"
const val PASSWORD="kotlin"

const val DEBUG=1

const val USERNAME_ADMIN="admin"
const val PASSWORD_DMIN="admin"
class ExpressionDemo{
    init {
        println("表达式的开始")
        //分支表达式
         if (USERNAME== PASSWORD){
             println("ok")
         }
         var mode= DEBUG
        //if 语句是有值的哦  ，这样的话也可以，但是必须有else才可以哦  就是要完备
         var mode3=if (mode== DEBUG&& USERNAME_ADMIN=="admin"&& PASSWORD_DMIN=="admin"){
             mode= DEBUG
          }else{
             mode=2
         }

        var WhenKtDemo=WhenKtDemo( )



    }
    //中缀 表达式
    class B{
        infix fun on(t:String) {}
    }

}