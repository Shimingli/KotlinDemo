package com.kotlin.demo.DSL_demo

/**
 * author： Created by shiming on 2018/3/17 15:28
 * mailbox：lamshiming@sina.com
 */
fun html(block:Tag.()->Unit):Tag{
    return Tag("html").apply(block)
}

fun html1(block:Tag.()->Unit):Tag{
    return Tag("html").apply{
        block(this)
    }
}

class StringNode(val content:String):Node{
    override fun render()=content
}

class Head:Tag("head")

class Boby :Tag("body"){
    var id by MapDelegate(proerties)

    var  `class`  by MapDelegate(proerties)
}
//fun Tag.head(block:Head.()->Unit):Tag 可以要tag  或者不要tag 也可以的
fun Tag.head(block:Head.()->Unit){
     this+Head().apply(block)
}
fun Tag.body(block:Boby.()->Unit){
    this+ Boby().apply(block)
}