package com.kotlin.demo.abstract_interface

/**
 * author： Created by shiming on 2018/3/6 14:22
 * mailbox：lamshiming@sina.com
 */
//单利
class Object{
    init {
       val MusicPlayer:MusicPlayer=MusicPlayer
    }
}
interface MountListener{
    fun onMount(driver: DriverT)
}
class DriverT
abstract class Player
//相当于java的单利  同时可以继承和实现
object MusicPlayer :Player(),MountListener{
    override fun onMount(driver: DriverT) {

    }

    val start:Int=0
    fun play(url:String){
        println("播放音乐")
    }
    fun  stop(){
        println("stop")
    }
}