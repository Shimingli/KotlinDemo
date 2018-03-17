package com.kotlin.demo.DSL_demo

import java.util.*

/**
 * author： Created by shiming on 2018/3/9 16:54
 * mailbox：lamshiming@sina.com
 */
open class Tag(val name: String):Node{
    val children=ArrayList<Node>()
    val proerties=HashMap<String,String>()
    /**
     * operator是C++和pascal的关键字，它和运算符一起使用，
     * 表示一个运算符函数，理解时应将operator=整体上视为一个函数名。
     */
    //扩展的方法写了的话   "id"("HtmlId")//需要支持 这种的方法 哈哈
    operator fun String.invoke(value :String){
         proerties[this]=value//this ==String
        println("shiming  是不是 这个扩展的方式 是实现的了哦 String.invoke( ")
    }
    //第二种的 扩展的方法
    /**  为了兼容这个办法  啊啊！！！
     *  "head"{

       }
     */
    operator fun String.invoke(block:Tag.()->Unit){
        children.add(Tag(this).apply(block))

    }
    //一元加号运算符
    operator fun String.unaryPlus(){
         children.add(StringNode(this))
    }

    // fun Tag.body(block:Boby.()->Unit){
  //  this@body.children+ Boby().apply(block)  扩展的是这个+号哦
    operator fun plus(node:Node){
        children.add(node)
    }
    // <html id="htmlId" style=""> <head> </head> <body></body></html>
    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .let{
                    stringBuilder ->//拼接的操作，在这里哦
                    if (!this.proerties.isEmpty()){
                        stringBuilder.append(" ")
                        this.proerties.forEach{//迭代
                            stringBuilder.append(it.key)
                                    .append("=\"")
                                    .append(it.value)
                                    .append("\"")
                        }
                    }
                    stringBuilder
                }
                .append(">")//这上面的等于说是<html id="htmlId" style="">
                .let {
                    stringBuilder ->//拼接的操作，在这里哦
                    children.map(Node::render).map(stringBuilder::append)
                    stringBuilder//返回值
                }
                .append("<$name>")
                .toString()
    }

}