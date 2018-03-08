package com.kotlin.demo.Higher_order_function

import com.kotlin.demo.MainActivity
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader

/**
 * author： Created by shiming on 2018/3/8 16:29
 * mailbox：lamshiming@sina.com
 */
class DemoKotlinFunction{
    init {
        val findPerson = findPerson()
        println(findPerson?.name)//null 告诉虚拟器为null的话  就给老子输出出来
        //null 告诉虚拟器这里肯定不为null  所以这行代码会直接报错  傻逼
       // println(findPerson!!.name)    Caused by: kotlin.KotlinNullPointerException
        println(findPerson?.name)
        println(findPerson?.age)
        com.kotlin.demo.Higher_order_function.findPerson()?.let {it->
            println(it.name)
            println(it.age)

        }
        com.kotlin.demo.Higher_order_function.findPerson()?.let {(name1,age2)->
            println(name1)
            println(age2)
        }
        com.kotlin.demo.Higher_order_function.findPerson()?.let {it->
            it.work()
        }
        //卧槽  apply  可以直接的调用啊 里面的对象  大哥 牛逼了哦
        com.kotlin.demo.Higher_order_function.findPerson()?.apply {
            work()
            println(age)
        }

        with(com.kotlin.demo.Higher_order_function.findPerson()){
            println("这样也可以的哦")
        }

    }

    fun setContext(mainActivity: MainActivity) {
        val inPublic = mainActivity.getResources().getAssets().open("Test.txt")
        val br = BufferedReader(InputStreamReader(inPublic))
        //val bufferedReader = BufferedReader(FileReader(""))
        with(br){
            var line:String?
            while (true){
                line= readLine()?:break
                println(line)
            }
           close()
        }
        //要把上面的方法注释掉哦 不注释掉的话，就重新的给老子new出来一个对象
         val text=BufferedReader(InputStreamReader( mainActivity.getResources().getAssets().open("Test.txt"))).readText()
        println("kotlin中读取文本 ")
        println(text)
       val linesss=BufferedReader(InputStreamReader( mainActivity.getResources().getAssets().open("Test.txt"))).readLine()

        println("kotlin中读取文本 readLine ")
        println(linesss)
        val inPublic1 = mainActivity.getResources().getAssets().open("Test.txt")
        val newbr= BufferedReader(InputStreamReader(inPublic1))
        newbr.use {// 里面已经 帮我们做了  关闭流的操作了哦
            with(newbr){
                var line1:String?
                println("使用user的话 ，我们这里 就不用关闭流了哦 ")
                while (true){
                    line1= readLine()?:break
                    println(line1)
                }
                //在这里 就不用关闭 流了哦
             //   close()
            }
        }

    }

}
data class Person(val name: String,val age:Int){
    fun work(): Unit {
        println("老子不想工作 $name")
    }
}

fun findPerson(): Person? {
   return null
}