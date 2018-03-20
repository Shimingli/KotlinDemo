package com.kotlin.demo.Coroutine_Demo

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*


/**
 * author： Created by shiming on 2018/3/19 14:46
 * mailbox：lamshiming@sina.com
 */
@SuppressLint("SimpleDateFormat")
val dateFormat=SimpleDateFormat("HH:mm:ss:SSS")

val nowDate={
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(msg:String)= println("${nowDate()} [@${Thread.currentThread().name}]$msg")