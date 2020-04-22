package com.kotlin.demo

import android.content.Intent
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.demo.Coroutine_Demo.CoroutineDemo
import com.kotlin.demo.Coroutine_Demo.https.lastChar
import com.kotlin.demo.Coroutine_Demo.https.plus
import com.kotlin.demo.Coroutine_Demo.sequence.SeqMain
import com.kotlin.demo.Currying_Demo.CurryingDemoKt
import com.kotlin.demo.Currying_Demo.Demo
import com.kotlin.demo.DSL_demo.DSLDemo
import com.kotlin.demo.Delegates.Delegates
import com.kotlin.demo.Expression.ExpressionDemo
import com.kotlin.demo.Extends.Extends
import com.kotlin.demo.Higher_order_function.DemoKotlinFunction
import com.kotlin.demo.Higher_order_function.HigherOrderFunction
import com.kotlin.demo.Higher_order_function.HigherOrderFunctionDemo
import com.kotlin.demo.abstract_interface.C
import com.kotlin.demo.abstract_interface.ClassCanSeeDemo
import com.kotlin.demo.abstract_interface.OverLoads
import com.kotlin.demo.abstract_interface.StaticDemo
import com.kotlin.demo.bean_demo.DataClass
import com.kotlin.demo.catch_demo.CatchDEmo
import com.kotlin.demo.class_demo.Gril
import com.kotlin.demo.closure.ClosureDemo
import com.kotlin.demo.compose_demo.ComposeDemoKt
import com.kotlin.demo.enum_demo.LogLevel
import com.kotlin.demo.fordemo.ForDemo
import com.kotlin.demo.generics.Generics
import com.kotlin.demo.innerClassDemo.InnerClassDemo
import com.kotlin.demo.java_reflections.JavaReflections
import com.kotlin.demo.operator.OperatorDemo
import com.kotlin.demo.parameter_demo.ParameterDemo
import com.kotlin.demo.sealed_class_demo.SealedClassDemo
import com.kotlin.demo.star_demo.StartDemo
import com.kotlin.demo.tailrecursive.Tailrecusive
import com.kotlin.demo.test1.Lamdda
import com.kotlin.demo.test1.MainTest
import kotlinx.coroutines.experimental.delay


@Suppress("UNUSED_EXPRESSION")
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

        println("mIN" + mAnotherInt)
        println("m2Int" + m2Int)
        println("mMaxInt " + mMaxInt)// 2147483647  32
        println("mMinInt " + mMinInt)// -2147483648

        println("mMaxInt" + (Math.pow(2.0, 31.0) - 1))
        println("mMinInt" + (-Math.pow(2.0, 31.0)))

        println("long " + 123L)

        println(Float.NEGATIVE_INFINITY)//-Infinity
        println(Float.POSITIVE_INFINITY)//Infinity
        println(Float.NaN)//NaN =0.0/0.0
        println(0.0 / 0.0)// NaN 不能0/0 因为  会报错哦

        println(mMaxDouble)//.7976931348623157E308
        println(mMinDouble)//-.7976931348623157E308
        println(mShort)//32767
        println(mMinShort)//-32768

        charDemo()

        stringDemo()
        //Any 所有的类的父亲
        val myFriend: Bean = Bean("18", "好看", "好听")
        val myTwoFriend: TwoBean = TwoBean("20", "甜美", "爽")

        println(myFriend is BaseBean)//true
        //通过这种的方法去  new起一个新的类 我的女朋友，她的特点:年级:18000,面部:好看,声音:好听
        val mDemo: TwoTwoBean = TwoTwoBean("18000", "好看", "好听")

        val value: NanClassJava = NanClassJava()
        //由于 返回为null  就会报错
        value.getName()
        //判断是否为null的话，就直接返回为 null  ，不是就返回长度
        val length = value.name?.length
        println(length)
        //下面表示为mString的变量有可能为null ，所以println的语句  String?
        val mString: String? = "www"
        println(mString!!.length)//告诉编译器 老子知道不为空

        //判断是不是null ，是空的话 ，就返回

        // value.name?:return
        println("上面return、 我打印不出啊")

        //rangeTo 区间
        val range: IntRange = 0..1024 //等于 [0,1024]
        val rang_exclusive: IntRange = 0 until 1024 //[0,1023]

        val emptyRange: IntRange = 0..-1

        println("shiming new shart ")

        println("emptyRange" + emptyRange.isEmpty())
        println("range" + range.contains(50))
        println("range" + range.contains(1024))
        println("range" + rang_exclusive.contains(1024))
        println("range" + rang_exclusive.contains(1023))

        println("true or false " + (20 in range))
        // for 循环在这里哦
//        for (i in range){
//            println("$i="+i)
//        }

        //数组 Array 一列对象，一点儿关系都没有哦

        val arrayInt: IntArray = intArrayOf(1, 3, 5, 7)
        val arrayCar: CharArray = charArrayOf('1', '2', '3', '4')
        val arrayString: Array<String> = arrayOf("string")

        val arrBean: Array<TwoTwoBean> = arrayOf(TwoTwoBean("a", "d", "d"))

        println("打印数据的size哦" + arrayInt.size)
        for (i in arrayCar) {
            println("$i=" + i)
        }
        //替换赋值的问题  数组的角标也是从0开始的
        println(arrayCar[1])
        arrayCar[1] = '\u00ff'
        println(arrayCar[1])

        arrayCar.joinToString()

        //1, ÿ, 3, 4
        println(arrayCar.joinToString())
        //不要逗号的 分割 ,, ,, ,, ,
        println(arrayCar.joinToString() { "," })
        //1ÿ34
        println(arrayCar.joinToString(""))
        //[ÿ, 3]  取出1和2角标的元素  切片
        println("shiming arraycar"+arrayCar.slice(1..2))

        //一些变量的操作的例子实例
        val FINAL_HELLO_WORLD: String = "Hello World"
        var helloWorld: String = FINAL_HELLO_WORLD
        var nullableHelloWorld: String? = helloWorld
        val helloWorldArray: Array<Char> = arrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd')
        val helloWorldCharArray: CharArray = charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd')
        val helloWorldLength: Int = helloWorld.length
        val helloWorldLengthLong: Long = helloWorldLength.toLong()

        println("final hello world: " + FINAL_HELLO_WORLD)
        println("assignable hello world: " + helloWorld)
        println("hello world from nullable type: " + nullableHelloWorld)
        println("hello world from Array: " + helloWorldArray.joinToString(""))
        println("hello world from CharArray: " + String(helloWorldCharArray))
        println("class name hello world: " + HelloWorld::class.java.simpleName)//HelloWorld
        println("class name hello world: " + HelloWorld::class.java.name)//com.kotlin.demo.HelloWorld
        println("part of the class name of HelloWorld: "
                + HelloWorld::class.java.simpleName.slice(0 until helloWorldLength - 2)) // [0, 11) 不包含 11啊
        println("the length of hello world is : " + helloWorldLength)
        println("the length of hello world is (long): " + helloWorldLengthLong)

        //变量的
        val mainTest: MainTest = MainTest()
        mainTest.toTest1()

        val lamdda: Lamdda = Lamdda()

        val gril = Gril("18", "182kg", "好看")
        gril.sing("爱我")

        val operatordemo = OperatorDemo(2.2, 2.4)
        val operatordemo2 = OperatorDemo(2.2, 2.4)
        //重写 toString的方法
        println(operatordemo.plus(operatordemo2))//com.kotlin.demo.operator.OperatorDemo@a675f990
        //当 重写 写了toString的方法的话 4.4+4.8

        println(operatordemo.plus(55551))


        val expressoin = ExpressionDemo()
        //for循环的
        val ForDemo = ForDemo()

        val CatchDEmo = CatchDEmo()
        //具名参数 ，变成参数
        val ParameterDemo = ParameterDemo()

        val C = C()


        val ClassCanSeeDemo = ClassCanSeeDemo()

        val StaticDemo = StaticDemo()
        val OverLoads = OverLoads()
        OverLoads.a(1)
        OverLoads.a()//不传入的话 ，就相当 只调用一个函数

        val Extends = Extends()

        val Delegates = Delegates()
        //数据类
        val DataClass = DataClass(0, "ddd")

        val inner = InnerClassDemo.Outrer().Inner()

      //  val inner2 = InnerClassDemo.Inner2()

       val InnerClassDemo = InnerClassDemo()


        println("枚举   start")
        println(LogLevel.DEBUG.getTag()) //2,++DEBUG
        // ordinal 表示是第几个位置  这样就知道枚举的位置在哪里
        println(LogLevel.DEBUG.ordinal) //==1
        println(LogLevel.VERROSE.ordinal) //==1
       // 打印元素 在这里
        LogLevel.values().map ( ::println )

        //DEBUG 我的名字在前面，1 这是我的位置，排在第几个的地方
        println(LogLevel.valueOf("DEBUG"))
        println("枚举  end")


        println("密封类 sealed class  start ")
        val SealedClassDemo :SealedClassDemo

        println("密封类 sealed class  end ")

        println("高阶函数 start ")
        val HigherOrderFunction= HigherOrderFunction()
        //Demo
        val HigherOrderFunctionDemo= HigherOrderFunctionDemo()
        val DemoKotlinFunction= DemoKotlinFunction()
        DemoKotlinFunction.setContext(this)

        println("高阶函数 end ")

        println("尾递归 优化  start")
        val Tailrecusive= Tailrecusive()
        println("尾递归 优化  end")

        println("闭包  start")
        val ClosureDemo= ClosureDemo()
        println("闭包  end")

        println("复合函数  start")
        val ComposeDemoKt= ComposeDemoKt()
        println("复合函数  end")

        println("柯里化  start")
        val CurryingDemoKt= CurryingDemoKt()
        val Demo= Demo(this)
        println("柯里化 偏函数  end")

        println("DSL  start")
        val DSLDemo= DSLDemo()
        println("DSL   end")
        findViewById<Button>(R.id.btn).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,CoroutineActivity::class.java))

        })
        /**
         * 多个线程相对独立，有自己的上下文，但是他的切换受了系统影响
         * 协程也是相对独立的，有自己的上下文，但是切换是有自己控制的，可以由自身决定
         * 是否切换到其他的协程中，
         */
        /**
         * 协程的优势：
         * 1、极高的执行的效率，协程的子程序切换不是线程控制的，而是
         * 有程序自身的控制，因此，协程没有线程切换的开销。
         * 2.不需要多线程的锁机制，只有一个线程，也不存在同时写变量的冲突
         * ，在协程中控制共享资源不加锁，只需要判断状态
         */
        val SeqMain= SeqMain()
        //协程的框架
        println("shiming  这里是延迟1s start"  +System.currentTimeMillis())
//         {
//            delay(1000)
////            println("shiming  这里是延迟1s end "  +System.currentTimeMillis())
////            println("shiming   这里是延迟1s Hello from Kotlin Coroutines!")
//        }
        println("shiming  Kotlin 中使用java 反射 start")
        val JavaReflections= JavaReflections()

        val StartDemo= StartDemo()

        val Generics= Generics()
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

        "me new Method".lastChar()

         val p1 = Point(10, 20)
         val p2 = Point(30, 40)
          println(p1 + p2)


    }
}

/**
 * 在Java中写一个main函数，你得先有一个类
 * 然而在Kotlin中就变得不一样了，main函数必须是写在类外面的，在idea中创建一个Kotlin File，
 * 写下下面的代码（输入main，然后按table就自动生成了）：
 *
 * 如果你是创建了一个Kotlin Class 文件，则在类外面写即可。
 * main函数是不依赖于类的，所以main函数是一个top-level函数
 *
 * 直接定义在文件之下，所以都是top-level。
 * 如果是在类体里面申明的变量，函数，class，object，enum就不是top-level
 */
fun main(args: Array<String>) {
    println("shiming  我是 topLevel 函数")
}