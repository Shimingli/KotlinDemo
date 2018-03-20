package com.kotlin.demo.Coroutine_Demo.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

/**
 * author： Created by shiming on 2018/3/20 14:37
 * mailbox：lamshiming@sina.com
 *
 *   companion object:伴生对象，应该怎么做呢？什么意思呢  哈哈
 * 伴生对象与单例模式相关,这个对象是Companion类的对象,伴随着Message类而生
 *
 */
//java中的 静态的static的成员，声明为静态成语的属性和方法在类的加载。解析的时候
//初始化，然后其生命周期与该类的生命周期绑定在一起

//kotlin中没有静态变量，So，它使用了伴生对象来模仿java中的静态变量
class DownLoadContext(val url:String):AbstractCoroutineContextElement(Key){
   //Kotlin的class并不支持static变量,所以需要使用companion object来声明static变量
    companion object  Key: CoroutineContext.Key<DownLoadContext>
}