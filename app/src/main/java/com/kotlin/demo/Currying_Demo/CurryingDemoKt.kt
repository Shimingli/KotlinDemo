package com.kotlin.demo.Currying_Demo

import java.io.OutputStream
import java.lang.System.out
import java.nio.charset.Charset

/**
 * author： Created by shiming on 2018/3/9 15:11
 * mailbox：lamshiming@sina.com
 */
//柯里化  函数调用链 把多个参数的函数，变成一些列单个参数的变换
class CurryingDemoKt{
  init {
      //[shiming]ces
      val PrintStream = out //System.out 麻痹是一个输出流啊
      log("shiming", PrintStream,"ces")

      //柯里化调用
      log1("kelihua")(PrintStream)("aaaa")
      //::log 表示取这个函数得引用
      ::log.curried()("kelihua")(PrintStream)("aaaa")

      //偏函数
      val consoleLogWihtTag=( ::log.curried()("kelihua")(PrintStream))
      consoleLogWihtTag("niubi1")
      consoleLogWihtTag("niubi2")
      consoleLogWihtTag("niubi3")
      val bytes="我是你的爹爹".toByteArray(charset("GBK"))
       val pianhanshu=consoleLogWihtTag2(bytes)
      println(pianhanshu)
  }
}
//这就是偏函数的例子 在这里哦
val makeString=fun (b:ByteArray,char:Charset):String{
    return String(b,char)
}
val consoleLogWihtTag2= makeString.partial2(charset("GBK"))

fun <P1,P2,R> Function2<P1,P2,R>.partial2(p2:P2)=fun(p1:P1)=this(p1,p2)
fun <P1,P2,R> Function2<P1,P2,R>.partial1(p1:P1)=fun(p2:P2)=this(p1,p2)


//高能的地方
 fun<P1,P2,P3,R> Function3<P1,P2,P3,R>.curried()
    =fun (p1:P1)=fun (p2:P2)=fun (p3:P3)=this(p1,p2,p3)

fun log(tag:String,target:OutputStream,message:Any?): Unit {
    target.write("[$tag]$message\n".toByteArray())
}
fun log1(tag:String)
     =fun (tag1:OutputStream)=fun (message:Any?)
      =tag1.write("[$tag]$message\n".toByteArray())

//  函数调用链 把多个参数的函数，变成一些列单个参数的变换
fun hello(x:String,y:Int,z:Double): Boolean {
   return true
}
//  函数调用链 把多个参数的函数，变成一些列单个参数的变换
//fun curriedHello(x: String):(y:Int)->(z:Double)-> Boolean {
//  return
//}