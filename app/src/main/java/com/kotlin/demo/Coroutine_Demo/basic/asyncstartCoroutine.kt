
import com.kotlin.demo.Coroutine_Demo.async.AsyncBaseContinuation
import com.kotlin.demo.Coroutine_Demo.https.HttpException
import com.kotlin.demo.Coroutine_Demo.https.HttpService
import com.kotlin.demo.Coroutine_Demo.log
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * author： Created by shiming on 2018/3/19 16:51
 * mailbox：lamshiming@sina.com
 */
fun startCoroutine(block:suspend ()->Unit){
    block.startCoroutine(AsyncBaseContinuation())
}
/**
 * 把数组转化成一个bitmap ImageLoda返回ByteArray
 */
 suspend fun ImageLoda(url: String)= suspendCoroutine<ByteArray> {
    con->
    try {
        /**
         * 解释一下，从Honeycomb SDK（3.0）开始，
         * google不再允许网络请求（HTTP、Socket）
         * 等相关操作直接在Main Thread类中，
         * 其实本来就不应该这样做，直接在UI线程进行网络操作，会阻塞U
         */
        val execute = HttpService.serviceDemo.getImg(url).execute()
        if (execute.isSuccessful){//成功了的话
            //读取bytes的数组，进行let操作，把这个
            //读到的bytes给con的resume的方法
            log("shiming 222")
            execute.body()?.byteStream()?.readBytes()?.let(con::resume)
        }else{
            log("shiming 3")
            //失败了给出一个异常
            con.resumeWithException(HttpException(execute.code()))
        }
    }catch (e:Exception){
        log("shiming"+e)
        con.resumeWithException(e)
    }
}