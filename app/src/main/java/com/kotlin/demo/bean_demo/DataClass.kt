package com.kotlin.demo.bean_demo

import com.kotlin.demo.annotations.PoKo

/**
 * author： Created by shiming on 2018/3/6 16:57
 * mailbox：lamshiming@sina.com
 */
@PoKo
data class DataClass(val id:Int,val name: String){
    init {
        //必须赋值
        val country=Country(110,"中国")
        println(country.toString())//com.kotlin.demo.bean_demo.Country@a673e558
        //加入了data输出了以后的值
        println(country.toString())//Country(id=110, name=中国)
        //自动生成的方法
        println(country.component1())
        println(country.component2())
        //卧槽 这样写  也是可以的啊  牛逼
        val (id,s)=country
        println(id)
        println(s)

        //和下面的方法是一样的哦
        val list= arrayOf(1,5,4,78,9,4)
        for ((index,value) in list.withIndex()){
            println("$index="+index)
            println(value)
        }

        val ComponentX=ComponentX()
        val (a,b,c,d)=ComponentX
        println("$a$b$c$d")// dd234
    }
}
//编译成了 final的  public final class com/kotlin/demo/bean_demo/DataClass   这是坑
@PoKo
data class Country(val id:Int,val name: String)
//麻痹的，一个dataBean 不能被继承啊
//class A: Country {
//
//}
class ComponentX{
    //名字的写对 component1 因为这是DataBean生成的  所以如果写错了的话 ，那么operator 会报错
    operator fun component1():String{
        return "dd"
    }
    operator fun component2():Int{
        return 2
    }
    operator fun component3():Int{
        return 3
    }
    operator fun component4():Int{
        return 4
    }
}