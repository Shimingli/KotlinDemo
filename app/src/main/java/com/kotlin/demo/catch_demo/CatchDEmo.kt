package com.kotlin.demo.catch_demo

/**
 * author： Created by shiming on 2018/3/5 17:50
 * mailbox：lamshiming@sina.com
 */
class CatchDEmo{
    init {
        println("catch 异常")

        try {
            val i=10

        }catch (e:NumberFormatException){

        }catch (e:ArrayIndexOutOfBoundsException){

        }catch (e:Exception){
            println("麻痹 简单的很   没意思啊")
        }finally {
            println("老子一定会执行哦！")
        }

        val any = try {
            val i = 0 / 0
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }

        println("异常出来的的数据"+any)
    }
}