package com.kotlin.demo.enum_demo


/**
 * author： Created by shiming on 2018/3/7 19:04
 * mailbox：lamshiming@sina.com
 * 使用enum 比较占用内存 ，但是呢 代码的结构比较清晰
 * 1、关注代码质量
 * 2、程序如果需要性能  不使用 枚举
 */
enum class LogLevel(val  id:Int){
    VERROSE(1),DEBUG(2),INGO(3),WARN(4);

    fun getTag(): String {

        return "$id,++$name"
    }

    /**
     * 03-06 20:57:01.180 23644-23644/? I/System.out: VERROSE
    03-06 20:57:01.180 23644-23644/? I/System.out: DEBUG
    03-06 20:57:01.180 23644-23644/? I/System.out: INGO
    03-06 20:57:01.180 23644-23644/? I/System.out: WARN
     以上 是没有复写 toString 的方法
     如果复写了 toString的方法的 ，输入的部分就是下面的地方
    03-06 21:00:12.240 23762-23762/com.kotlin.demo I/System.out: VERROSE 我的名字在前面，0 这是我的位置，排在第几个的地方
    03-06 21:00:12.240 23762-23762/com.kotlin.demo I/System.out: DEBUG 我的名字在前面，1 这是我的位置，排在第几个的地方
    03-06 21:00:12.240 23762-23762/com.kotlin.demo I/System.out: INGO 我的名字在前面，2 这是我的位置，排在第几个的地方
    03-06 21:00:12.240 23762-23762/com.kotlin.demo I/System.out: WARN 我的名字在前面，3 这是我的位置，排在第几个的地方
     */
    override fun toString(): String {
        return "$name 我的名字在前面，$ordinal 这是我的位置，排在第几个的地方"
    }
}
class LogLevel2  constructor(){
    //伴生对象
   companion object {
       val VERROSE= LogLevel2()
       val DEBUG= LogLevel2()
       val INGO= LogLevel2()
       val WARN= LogLevel2()

   }
}