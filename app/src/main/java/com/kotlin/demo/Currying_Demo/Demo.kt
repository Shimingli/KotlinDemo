package com.kotlin.demo.Currying_Demo

import com.kotlin.demo.MainActivity
import java.io.File
import java.io.InputStreamReader

/**
 * author： Created by shiming on 2018/3/9 16:17
 * mailbox：lamshiming@sina.com
 */
class Demo(val mainActivity: MainActivity){
    init {
        val map=HashMap<Char,Int>()
        val inPublic = mainActivity.getResources().getAssets().open("build11.gradle11")
        val inputStreamReader = InputStreamReader(inPublic)
        //先读取文字 ，然后转成字符串，然后去掉 空格，再来便利
         inputStreamReader.readText().toCharArray()
                .filterNot(Char::isWhitespace).forEach {
                    val i = map[it] //统计的元素是正确的哦
                    if (i==null)map[it]=1
                    else map[it]=i+1
                }
        inputStreamReader.close()
        map.forEach(::print)
        for (mutableEntry in map) {
            //统计 出现的次数   哈哈哈哈
            println("元素===="+mutableEntry)
        }
       //元素====依=1
        val inPublic1 = mainActivity.getResources().getAssets().open("build11.gradle11")
        val inputStreamReader1 = InputStreamReader(inPublic1)
        println("!!!!!!!!!!!!!!!!!!!!!!!")
        //groupBy 分组的依据是 我们的字符  合成完了成为list的集合
        //元素就成为单独的list集合
        //然后合成一个map的集合
        //key 为字符 value为这个字符集合的长度的长度
        inputStreamReader1.readText().toCharArray()
                .filterNot(Char::isWhitespace).groupBy { it }.map {
                    it.key to it.value.size
                }.forEach(::print)
    }
}