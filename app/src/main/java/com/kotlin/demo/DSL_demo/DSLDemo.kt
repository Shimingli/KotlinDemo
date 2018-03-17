package com.kotlin.demo.DSL_demo

/**
 * author： Created by shiming on 2018/3/9 16:49
 * mailbox：lamshiming@sina.com
 */

/**
 * 领域特定语言 只在特定语言使用  html  gradle   SQL
 * java he C++ 更具有表达力
 */
class DSLDemo{
   init {
       val apply = Tag("html").apply {
           proerties["id"] = "htmlId"
           children.add(Tag("head"))
       }.render()
       println("shiming dsl=="+apply)  //<html id="htmlId"><head><head><html>
       println("shiming dsl==另外一种的打印的方式")

       /**
        * (Standard.kt)中提供了一些Kotlin扩展的内置函数可以优化kotlin的编码
        * Standard.kt是Kotlin库的一部分，它定义了一些基本函数。
        * 这个源代码文件虽然一共不到50行代码，但是这些函数功能都非常强大
        * let扩展函数的实际上是一个作用域函数，
        * 当你需要去定义一个变量在一个特定的作用域范围内，let函数的是一个不错的选择
        *
         场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。
       场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用

       没有使用let函数的代码是这样的，看起来不够优雅
       mVideoPlayer?.setVideoView(activity.course_video_view)
       mVideoPlayer?.setControllerView(activity.course_video_controller_view)
       mVideoPlayer?.setCurtainView(activity.course_video_curtain_view)


       mVideoPlayer?.let {
       it.setVideoView(activity.course_video_view)
       it.setControllerView(activity.course_video_controller_view)
       it.setCurtainView(activity.course_video_curtain_view)
       }

        */

       Tag("html").apply {
           proerties["id"]="shiming"
           children.add(Tag("head"))
       }.render().let(::println)//<html id="shiming"><head><head><html>

       println("shiming dsl==另外一种的打印的方式222 和上面的打印的结果是一样的哦")

       html {
           proerties["id"]="shiming"
           children.add(Tag("head"))
       }.render().let(::println)
       println("shiming  这里开始执行了的么  start ")
       html1 {
           "id"("shiming=HtmlId")//需要支持 这种的方法 哈哈
//           proerties["id"]="shiming"
           children.add(Tag("head"))
           println("shiming  这里开始执行了的么  ？？")
       }.render().let(::println)

       // <html id="shiming new=HtmlId"><head id="shiming =HtmlId"><head><html>
       html {
           "id"("shiming new=HtmlId")
          // children.add(Tag("head"))
           "head"{
               "id"("shiming =HtmlId")
           }
       }.render().let(::println)

      //<html id="shiming new new new new =HtmlId"><head><a href="https://www.jianshu.com/u/a58eb984bda4"><a><head><html>
      //这个 不管用的哦
       html {
           "id"("shiming new new new new =HtmlId")
           // children.add(Tag("head"))
           "head"{//
               "a"{
                   "href"("https://www.jianshu.com/u/a58eb984bda4")
                   "仕明的简书的地址在这里哦"
               }

           }
       }.render().let(::println)


       //这里的呢 也是一个运算符的重载的动作  浏览器 对特定的标签有支持的哦
       html {
           "id"("shiming new new new new =HtmlId")
           // children.add(Tag("head"))
           "head"{//
               "a"{
                   "href"("https://www.jianshu.com/u/a58eb984bda4")
                   +"仕明的简书的地址在这里哦"
               }

           }
       }.render().let(::println)

       println("shiming 最牛的版本在这里")
       //<html id="shiming new new new new =HtmlId"><html> 要改其他的方法 改了方法的时候
       //<html id="HtmlId"><head id="headId"><head><body id="bodyId"class="bodyClass"><a href="https://www.jianshu.com/u/a58eb984bda4">仕明的简书的地址在这里哦<a><body><html>
       html {
           "id"("HtmlId")
           "head"{
               "id"("headId")
           }
           body{
               id="bodyId"
               `class`="bodyClass"
               "a"{
                   "href"("https://www.jianshu.com/u/a58eb984bda4")
                   +"仕明的简书的地址在这里哦"
               }
           }
           "div"{
               "href"("https://www.jianshu.com/u/a58eb984bda4")
               +"shiming仕明的简书的地址在这里哦"
           }
       }.render().let(::println)

   }
}