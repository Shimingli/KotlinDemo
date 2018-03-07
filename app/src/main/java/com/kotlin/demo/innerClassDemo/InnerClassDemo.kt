package com.kotlin.demo.innerClassDemo

/**
 * author： Created by shiming on 2018/3/7 14:20
 * mailbox：lamshiming@sina.com
 */

class InnerClassDemo {
    val o1: Int = 0
    init {
        val inner2 = Inner2()
        println("注意写法是怎么样子")

        val view=View()
        //这是 kotlin的语言和 java中的内部类的区别  就在下面
        view.onClickListener=object :Outrer(), OnClickListener{
            override fun onClick() {
                println("匿名 内部类")
            }
        }
        view.onClick()
    }
    //默认是  静态的
   inner  class Inner2 {
        init {
            //这两个的写法是一样的哦
            println(o1)
            //通过这种的方式访问外部的类
            println(this@InnerClassDemo.o1)
        }
    }
    //记得 open 可以打开的哦
   open class Outrer {
        init {
           println("同时我们已经在初始化了 哈哈 ")
        }

        //非静态的类
        inner class Inner {
            init {
                println("我们内部类")
            }
        }

        // public static final class Inner2  反编译为静态的
        inner class Inner2 {
            init {

            }
        }
    }
}

interface OnClickListener{
    fun onClick()
}
class View{
     var onClickListener:OnClickListener?=null
    fun onClick(){
        onClickListener!!.onClick()
    }
    init {
        //告诉 虚拟器  我onclicklistener 不能为null
        //但是其实这个早在前面都已经 初始化完成了
        //TODO() 注释掉 为了不报错
        //onClickListener!!.onClick()
    }
}