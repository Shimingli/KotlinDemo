package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 11:32
 * mailbox：lamshiming@sina.com
 */
class Manager:Driver,Writer {
    override fun writer() {

    }

    override fun driver() {

    }
}
//old的写法 ，没有屌用
class SeniorManager(val driver: Driver,val writer: Writer):Driver,Writer{
    override fun writer() {
        writer.writer()
    }

    override fun driver() {
        driver.driver()
    }

}
//kotlin 接口代理  写的时候 比较牛逼
//属性代理
class SeniorManagerNew(val driver: Driver,val writer: Writer):Driver by driver,Writer by writer{

}
class CarDriver:Driver{
    override fun driver() {
        println("老司机在开车哦")
    }

}
class PPTWriter:Writer{
    override fun writer() {
        println("PPT高手 在这里")
    }

}
interface Writer{
    fun writer()
}
interface Driver{
    fun driver()
}