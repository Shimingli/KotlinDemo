package com.kotlin.demo

import ImageLoda
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.demo.Coroutine_Demo.CoroutineDemo
import com.kotlin.demo.Coroutine_Demo.LOGO_URL

import com.kotlin.demo.Coroutine_Demo.getPicFromBytes
import com.kotlin.demo.Coroutine_Demo.log
import startCoroutine
import android.graphics.Bitmap
import com.kotlin.demo.Coroutine_Demo.async.*


@Suppress("UNREACHABLE_CODE")
/**
 * 使用异步协程的Demo ，协程没有异步的能力，所以说我们执行的代码 会
 * 出异常
 */
class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)
        init()
    }

    private fun init() {
        val imageView = findViewById<ImageView>(R.id.image)
        val text = findViewById<TextView>(R.id.text)
        val imageView1 = findViewById<ImageView>(R.id.image1)
        val text1 = findViewById<TextView>(R.id.text1)
        val imageView2 = findViewById<ImageView>(R.id.image2)
        val text2 = findViewById<TextView>(R.id.text2)
        val imageView3 = findViewById<ImageView>(R.id.image3)
        val text3 = findViewById<TextView>(R.id.text3)
        //全部在主线程的操作哦 哈哈  使用的是第三方的框架使用的Retorfit
//        val CoroutineDemo= CoroutineDemo(imageView,text)
        // 第二种是在主线程进行了网络加载的错误。所以会报错，这里不行，加载不出来图片的地方哦  NetworkOnMainThreadException
//        TODO()//NetworkOnMainThreadException
        text.setOnClickListener(View.OnClickListener {
            startCoroutine {
               val imageDaga= ImageLoda(LOGO_URL)
                val bitmap1= BitmapFactory.Options()
                val picFromBytes = getPicFromBytes(imageDaga, bitmap1)
                imageView.setImageBitmap(picFromBytes)
            }
        })
        //第三种开启了一个线程池执行的动作 都会在子线
        text1.setOnClickListener(View.OnClickListener {
            startCoroutine {
                val imageDaga= asyncImageLodaMore(LOGO_URL)
                val bitmap1= BitmapFactory.Options()
                val picFromBytes = getPicFromBytes(imageDaga, bitmap1)
                log("shiming 最后回来的数据在哪个线程呢")
                /**
                 * 这里也是在线程池中更新ui ，为啥子 没有报错呢
                 * 草拟吗的 傻逼   线程池中 更新
                 */
               imageView1.setImageBitmap(picFromBytes)
                if (picFromBytes != null) {
                    // Only the original thread that created a view hierarchy can touch its views.
//                    onClick(imageView1,picFromBytes)
                }
            }
        })

        text2.setOnClickListener(View.OnClickListener {
            asyncstartCoroutine {
                val imageDaga= asyncImageLodaMore(LOGO_URL)
                val bitmap1= BitmapFactory.Options()
                val picFromBytes = getPicFromBytes(imageDaga, bitmap1)
                imageView2.setImageBitmap(picFromBytes)
            }
        })
        //线程安全的问题
        text3.setOnClickListener(View.OnClickListener {
            log("shiming 开始协程的地方  aaa")
            我要开始协程啦(DownLoadContext(LOGO_URL)) {
                log("shiming 开始协程的地方  bbb")
                这是最后的封装的方法封装了耗时的操作 {
                    log("shiming 开始协程的地方  ccc")
                    //不直接引用url 轻质
                    val data=这是最后的封装的方法开始加载图片(this[DownLoadContext]!!.url)
                    val bitmap1= BitmapFactory.Options()
                    val picFromBytes = getPicFromBytes(data, bitmap1)
                    imageView3.setImageBitmap(picFromBytes)
                }
            }

        })
    }
}

fun onClick(v: ImageView,b:Bitmap) {
    Thread(Runnable {
        log("shiming  onClick 最后回来的数据在哪个线程呢")
        v.setImageBitmap(b)
    }).start()
}