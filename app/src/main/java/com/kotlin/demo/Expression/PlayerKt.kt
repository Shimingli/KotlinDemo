package com.kotlin.demo.Expression

/**
 * author： Created by shiming on 2018/3/5 16:32
 * mailbox：lamshiming@sina.com
 */
class Player {

    private var state = State.IDLE

    internal enum class State {
        IDLE, BUFFERING, PLAYING, PAUSED
    }

    fun pause() {
        when (state) {
            Player.State.BUFFERING, Player.State.PLAYING -> doPause()
        }//什么都不做
    }

    fun resume() {
        when (state) {
            Player.State.PAUSED -> doResume()
        }//什么都不做
    }

    private fun doResume() {
        state = State.PLAYING
        //处理真正的继续播放逻辑
    }

    private fun doPause() {
        state = State.PAUSED
        //处理真正的暂停逻辑
    }
}