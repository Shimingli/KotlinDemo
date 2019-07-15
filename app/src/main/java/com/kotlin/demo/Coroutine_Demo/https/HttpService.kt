package com.kotlin.demo.Coroutine_Demo.https

import android.graphics.Point
import com.kotlin.demo.Coroutine_Demo.log
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KProperty


/**
 * author： Created by shiming on 2018/3/19 11:17
 * mailbox：lamshiming@sina.com
 * object是lazy-init，即在第一次使用时被创造出来的  以object来声明一个类时，表示这是一个单例类
 * object 声明不能放在函数中，但是可以放在其他object 声明中或者类声明中
 * //https://upload.jianshu.io/collections/images/551812/crop1508603355729.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240
 */
object HttpService{
    val serviceDemo by lazy {
          val retrofit=Retrofit.Builder().baseUrl("https://upload.jianshu.io")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
        log("shiming retrofit  into ")
        retrofit.create(Service::class.java)
    }

}
interface Service{
    @retrofit2.http.GET
    fun getImg(@retrofit2.http.Url fileURL: String):retrofit2.Call<ResponseBody>
}

fun String.lastChar(): Char = get(length - 1)

/**
 * Point 安卓中的类，我们支持运算符重载
 */
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

