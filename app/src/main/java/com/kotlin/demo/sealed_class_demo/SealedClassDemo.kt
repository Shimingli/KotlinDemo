package com.kotlin.demo.sealed_class_demo

/**
 * author： Created by shiming on 2018/3/7 19:33
 * mailbox：lamshiming@sina.com
 */
//sealed 密封的 色楞得
//SealedClassDemo 只能定义在 一个文件里 ，或者是内部类
//koltin 的新的概念，所以说呢 ，以后有用到过的话 ，得好好去理解 理解
//也就是说，我们有一个具有特定数量的子类的类。最后，我们得到的结论是非常类似枚举的概念。
// 所不同的是，在枚举中，我们每个类型只有一个对象；而在密封类中，同一个类可以拥有几个对象
sealed class SealedClassDemo{

    //在 kotlin 1.1以前 sealedClass 的子类只能 定义在 内部

//     init {
//
//     }
//    class AAA(val a:String,val p:Long=0) :SealedClassDemo()
//    class BBB(val a:String) :SealedClassDemo()
//
//    object PP:SealedClassDemo()
//    object PPP:SealedClassDemo()
//    object PPPP:SealedClassDemo()

}
//在 kotlin 1.1 以后呢  子类可以定义的外部
//class AAA(val a:String,val p:Long=0) :SealedClassDemo()
//class BBB(val a:String) :SealedClassDemo()
//
//object PP:SealedClassDemo()
//object PPP:SealedClassDemo()
//object PPPP:SealedClassDemo()