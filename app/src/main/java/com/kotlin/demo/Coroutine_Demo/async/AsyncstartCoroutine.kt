
import com.kotlin.demo.Coroutine_Demo.async.AsynTask
import com.kotlin.demo.Coroutine_Demo.async.AsyncBaseContinuationMore
import com.kotlin.demo.Coroutine_Demo.async.AsyncContext
import com.kotlin.demo.Coroutine_Demo.async.UiContinuationWrapper
import com.kotlin.demo.Coroutine_Demo.https.HttpError.HTTP_ERROR_UNKNOWN
import com.kotlin.demo.Coroutine_Demo.https.HttpException
import com.kotlin.demo.Coroutine_Demo.https.HttpService
import com.kotlin.demo.Coroutine_Demo.log
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine


/**
 * author： Created by shiming on 2018/3/19 16:51
 * mailbox：lamshiming@sina.com
 */
fun asyncstartCoroutine(block: suspend () -> Unit) {
    block.startCoroutine(AsyncBaseContinuationMore(AsyncContext()))
}

/**
 * 把数组转化成一个bitmap ImageLoda返回ByteArray
 */
suspend fun asyncImageLoda(url: String) = suspendCoroutine<ByteArray> { con ->
    log("shiming asyncImageLoda->异步的操作在这里哦") //主线程中
    AsynTask {
        try {
            /**
             * 解释一下，从Honeycomb SDK（3.0）开始，
             * google不再允许网络请求（HTTP、Socket）
             * 等相关操作直接在Main Thread类中，
             * 其实本来就不应该这样做，直接在UI线程进行网络操作，会阻塞U
             */
            log("shiming 111111111asyncImageLoda->异步的操作在这里哦")//子线程中
            val execute = HttpService.serviceDemo.getImg(url).execute()
            log("shiming 2222asyncImageLoda->异步的操作在这里哦")//子线程中
            if (execute.isSuccessful) {//成功了的话
                //读取bytes的数组，进行let操作，把这个
                //读到的bytes给con的resume的方法
                log("shiming 333333333asyncImageLoda->异步的操作在这里哦")
                execute.body()?.byteStream()?.readBytes()?.let(con::resume)
            } else {
                //失败了给出一个异常
                con.resumeWithException(HttpException(execute.code()))
            }
        } catch (e: Exception) {
            log("shiming Exception asyncImageLoda->异步的操作在这里哦" + e)
            con.resumeWithException(e)
        }
    }.execute()
}

/**
 * 转化到异步的地方，但是没有工作，所以我先写了一个例子
 */
suspend fun asyncImageLodaMore(url: String) = suspendCoroutine<ByteArray> {
    con ->
    //这里感觉不太好，这里还有写个方法
    val uiContinuationWrapper= UiContinuationWrapper(con)
    AsynTask {
        try {
            val execute = HttpService.serviceDemo.getImg(url).execute()
            if (execute.isSuccessful) {//成功了的话
                //读取bytes的数组，进行let操作，把这个
                //读到的bytes给con的resume的方法
                execute.body()?.byteStream()?.readBytes()?.let(){
              //              TODO()切线程  写了三遍的切线程的动作
                    println("shiming 这里开始切换线程了 start ")
                    uiContinuationWrapper.resume(it)
                }
            } else {
                //失败了给出一个异常
                //    TODO()切线程
                uiContinuationWrapper.resumeWithException(HttpException(execute.code()))
            }
        } catch (e: Exception) {
            //   TODO()切线程
            uiContinuationWrapper.resumeWithException(e)
        }
    }.execute()
}
//组合对象的话，context这里可以+在一起
fun 我要开始协程啦(context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit) {
    block.startCoroutine(AsyncBaseContinuationMore(context + AsyncContext()))
}

suspend fun<T> 这是最后的封装的方法封装了耗时的操作(block: CoroutineContext.()->T) = suspendCoroutine<T> {
    con ->
    AsynTask {
        try {
          con.resume(block(con.context))
        } catch (e: Exception) {
            con.resumeWithException(e)
        }
    }.execute()
}
 fun 这是最后的封装的方法开始加载图片(url:String) :ByteArray {
    val execute = HttpService.serviceDemo.getImg(url).execute()
    if (execute.isSuccessful){
        execute.body()?.byteStream()?.readBytes()?.let {
            return it
        }
        throw HttpException(HTTP_ERROR_UNKNOWN)
    }else{
        throw HttpException(execute.code())
    }
}