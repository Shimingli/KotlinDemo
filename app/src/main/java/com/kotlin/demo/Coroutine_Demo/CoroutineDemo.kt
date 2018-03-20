package com.kotlin.demo.Coroutine_Demo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.demo.Coroutine_Demo.https.HttpError
import com.kotlin.demo.Coroutine_Demo.https.HttpException
import com.kotlin.demo.Coroutine_Demo.https.HttpService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.BitmapFactory
import android.graphics.Bitmap




/**
 * author： Created by shiming on 2018/3/19 10:24
 * mailbox：lamshiming@sina.com
 * 分析：线程Thread 每一个线程都代表一个执行的序列，当程序中创建多线程的时候，看起来多个线程是
 * 同时执行的，不过实质上多个线程是并发的，因为只有一个CPU，所以实质上同一个时刻只有一个线程在执行
 * 在一个时间片执行的是那个线程是不确定的，我们可以控制线程的优先级，不过真正的线程调度是有cpu决定的
 *
 * 协程：协程跟线程都代表一个执行的序列，不同的是，协程中不确定的地方尽可能的去掉，执行序列简的切换不再有CPU隐藏的进行
 * 而是有程序显式的进行，所以，使用协程实现并发，需要多个协程 彼此的协作
 */
const val LOGO_URL = "https://upload.jianshu.io/collections/images/551812/crop1508603355729.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240"
class CoroutineDemo(imageView: ImageView, text: TextView) {
    init {
        println("shiming coroutine  协程start  全他妈的都在主线程  草拟吗比"+imageView)
        log("shiming 111")
        text.setOnClickListener(View.OnClickListener {
            HttpService.serviceDemo.getImg(LOGO_URL)
                .enqueue(object : Callback<ResponseBody> {
                     override fun onResponse(
                             call: Call<ResponseBody>,
                             response: Response<ResponseBody>) {
                        if (response.isSuccessful) {
                            log("shiming 222")
                            val imageData = response.body()?.byteStream()?.readBytes()
                            if (imageData == null) {
                                throw HttpException(HttpError.HTTP_NO_DATA)
                            } else {
                                log("shiming 444")
                                println("shiming coroutine imageData="+imageData)
                                println(imageData)
                                val bitmap1= BitmapFactory.Options()
                                val  bitmap=getPicFromBytes(imageData,bitmap1)
                                imageView.setImageBitmap(bitmap)
                            }
                        } else {
                            throw HttpException(response.code())
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        throw HttpException(HttpError.HTTP_ERROR_UNKNOWN)
                    }
                })
        })
    }
}

/**
 * @param 将字节数组转换为ImageView可调用的Bitmap对象
 * @param bytes
 * @param opts
 * @return Bitmap
 */
fun getPicFromBytes(bytes: ByteArray?,
                    opts: BitmapFactory.Options?): Bitmap? {
    return if (bytes != null)
        if (opts != null)
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size,
                opts)
    else
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size) else null
}