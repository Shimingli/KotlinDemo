package com.kotlin.demo.java_reflections

/**
 * author： Created by shiming on 2018/3/27 16:28
 * mailbox：lamshiming@sina.com
 */
/**
 * public enum class AnnotationRetention {
/** Annotation isn't stored in binary output */
SOURCE,
/** Annotation is stored in binary output, but invisible for reflection */
BINARY,
/** Annotation is stored in binary output and visible for reflection (default retention) */
RUNTIME
}
 */
//注解 AnnotationRetention
// SOURCE代表的是这个Annotation类型的信息
// 只会保留在程序源码里，源码如果经过了编译之后，
// Annotation的数据就会消失,并不会保留在编译好的.class文件里面

//ClASS的意思是这个Annotation类型的信息保留在程序源码里,
// 同时也会保留在编译好的.class文件里面,在执行的时候，
// 并不会把这一些信息加载到虚拟机(JVM)中去.注意一下，
// 当你没有设定一个Annotation类型的Retention值时，系统默认值是CLASS.


//RUNTIME,表示在源码、编译好的.class文件中保留信息，在执行的时候会把这一些信息加载到JVM中去的．
// 举一个例子，如@Override里面的Retention设为SOURCE,编译成功了就不要这一些检查的信息;相反,
// @Deprecated里面的Retention设为RUNTIME,表示除了在编译时会警告
//我们使用了哪个被Deprecated的方法,在执行的时候也可以查出该方法是否被Deprecated.
@Retention(AnnotationRetention.BINARY)
annotation class Poko2

//注解 使用的范围
//通常指向了class
//这里新定义了一个注解指向了fifld
@Target(AnnotationTarget.FIELD)
annotation class Another