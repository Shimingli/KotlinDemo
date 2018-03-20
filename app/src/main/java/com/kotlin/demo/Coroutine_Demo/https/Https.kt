package com.kotlin.demo.Coroutine_Demo.https

/**
 * author： Created by shiming on 2018/3/19 11:11
 * mailbox：lamshiming@sina.com
 */
data class HttpException(val  code:Int):Exception()

object HttpError{
    //const只能修饰val，不能修饰var 不可变的数据
    //经过const修饰的常量，才是java中理解的常量
    const val HTTP_NO_DATA=999
    const val HTTP_ERROR_UNKNOWN=998
}