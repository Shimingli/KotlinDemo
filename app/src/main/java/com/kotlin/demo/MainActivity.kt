package com.kotlin.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val mBoolean:Boolean=true//相当于  开关

    val mFalseBoolean:Boolean=false
    val mInt:Int =8 //是int Integer 的合体 ，在kotlin中不关心装箱的问题

    val mAnotherInt :Int=0XFF //表示一个十六进制的无符号的整数，十进制表示255
     val m2Int:Int =0b000000000011 //二进制 表示3
    val mMaxInt:Int=Int.MAX_VALUE
    val mMinInt:Int=Int.MIN_VALUE

    val mLong:Long=14545515454544
    val mAnotherLong:Long=123
    val mMaxLong:Long=Long.MAX_VALUE //64位
    val mMinLong:Long=Long.MIN_VALUE

    val mFloat:Float=2.0f //2.0 在kotlin中是双精度类型
    val  mMaxFloat:Float= Float.MAX_VALUE
    val  mMinFloat:Float= Float.MIN_VALUE
    //float 中的最小值  不能用min——value值，应该使用max——value的负数
    //float 中有POSITIVE_INFINITY 正无穷 和 负无穷大 还有不是数NaN
    val mDouble:Double=2.0

    val mMaxDouble:Double= Double.MAX_VALUE
    val mMinDouble:Double= -Double.MAX_VALUE

    val mShort:Short= Short.MAX_VALUE
    val mMinShort:Short= Short.MIN_VALUE


    val mByte:Byte=127//-128 到127
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //你好 kotlin
        println("Holle_Word")

        println("mIN"+mAnotherInt)
        println("m2Int"+m2Int)
        println("mMaxInt "+mMaxInt)// 2147483647  32
        println("mMinInt "+mMinInt)// -2147483648

        println("mMaxInt" +(Math.pow(2.0,31.0)-1))
        println("mMinInt" +(-Math.pow(2.0,31.0)))

        println("long "+123L)

        println(Float.NEGATIVE_INFINITY)//-Infinity
        println(Float.POSITIVE_INFINITY)//Infinity
        println(Float.NaN)//NaN =0.0/0.0
        println(0.0/0.0)// NaN 不能0/0 因为  会报错哦

        println(mMaxDouble)//.7976931348623157E308
        println(mMinDouble)//-.7976931348623157E308
        println(mShort)//32767
        println(mMinShort)//-32768

        charDemo()

        stringDemo()
        //Any 所有的类的父亲
         val myFriend:Bean=Bean("18","好看","好听")
        val  myTwoFriend :TwoBean= TwoBean("20","甜美","爽")

        println(myFriend is BaseBean)//true
        //通过这种的方法去  new起一个新的类 我的女朋友，她的特点:年级:18000,面部:好看,声音:好听
        val  mDemo:TwoTwoBean= TwoTwoBean("18000","好看","好听")

        val value: NanClassJava = NanClassJava()
         //由于 返回为null  就会报错
        value.getName()
        //判断是否为null的话，就直接返回为 null  ，不是就返回长度
        val length = value.name?.length
        println(length)
        //下面表示为mString的变量有可能为null ，所以println的语句  String?
        val  mString:String?="www"
        println(mString!!.length)//告诉编译器 老子知道不为空

        //判断是不是null ，是空的话 ，就返回

        value.name?:return
        println("上面return、 我打印不出啊")
    }
    //一个构造方法，可以不要 constructor  继承
    class Bean constructor(  eag:String, face:String, voice:String):BaseBean(eag, face, voice){
        init {
            println("我的女朋友1，她的特点:年级:$eag,面部:$face,声音:$voice")
        }
    }
    //一个构造方法，可以不要 constructor
    class TwoBean constructor(eag:String, face:String,voice:String):BaseBean(eag,face,voice){
        init {
            println("我的女朋友2，她的特点:年级:$eag,面部:$face,声音:$voice")
        }
    }
    //定义基类,人的基类  open 打开的  不是finnaly  能够继承
   open class BaseBean constructor(var eag: String,var face: String,var voice: String){
        init {
            println("我的女朋友2，她的名字${this.javaClass.simpleName}:年级:$eag,面部:$face,声音:$voice")
        }
    }


    //下面这样写 也是可以的哦
    class NewBean constructor(var eag:String,var face:String,var voice:String)
    val myFriend:Bean=Bean("18","好看","好听")

    private fun stringDemo() {

        val string :String ="HelloWord"
        val fromChars:String= String(charArrayOf('H','e','l','l','o','W','o','r','d'))
        println(string==fromChars)//等于equals
        //比较两个对象是否为同一个对象
        println(string===fromChars)//
        println("text"+string)//

        val arg1:Int=0
        val arg2:Int=1
        println(""+arg1+"+"+arg2+"="+(arg1+arg2))
        //kotlin的特性问题 更加特性 php中支持
        println("$arg1+$arg2=${arg1+arg2}")

        // 转移符
        val sayHello:String="Hellp\"Trump\""
         println(sayHello)
         //
        println("$1000")

        val salary:Int=1000
        println("$salary")  //没有$了
        println("\$salary")  //有$了

        val rawString :String="""
            \t

            \n """

        println(rawString)  //有$了

        println(rawString.length)

    }

    /**
     * Char 类型
     */
    private fun charDemo() {
       val aChar :Char ='0'
       val bChar :Char ='份'
       val cChar :Char ='\u000f'//unicode 的编码

        println(aChar)
        println(bChar)
        println(cChar)

        val anInt:Int=5
        val aLong :Long=anInt.toLong()//需要toLong

    }
}
