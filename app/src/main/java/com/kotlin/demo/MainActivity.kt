package com.kotlin.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.demo.Expression.ExpressionDemo
import com.kotlin.demo.Extends.Extends
import com.kotlin.demo.abstract_interface.C
import com.kotlin.demo.abstract_interface.ClassCanSeeDemo
import com.kotlin.demo.abstract_interface.OverLoads
import com.kotlin.demo.abstract_interface.StaticDemo
import com.kotlin.demo.catch_demo.CatchDEmo
import com.kotlin.demo.class_demo.Gril
import com.kotlin.demo.fordemo.ForDemo
import com.kotlin.demo.operator.OperatorDemo
import com.kotlin.demo.parameter_demo.ParameterDemo
import com.kotlin.demo.test1.Lamdda
import com.kotlin.demo.test1.MainTest

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

       // value.name?:return
        println("上面return、 我打印不出啊")

        //rangeTo 区间
        val range:IntRange=0..1024 //等于 [0,1024]
        val rang_exclusive:IntRange =0 until 1024 //[0,1023]

        val emptyRange:IntRange=0..-1

        println("shiming new shart ")

        println("emptyRange"+emptyRange.isEmpty())
        println("range"+range.contains(50))
        println("range"+range.contains(1024))
        println("range"+rang_exclusive.contains(1024))
        println("range"+rang_exclusive.contains(1023))

        println("true or false "+(20 in range))
       // for 循环在这里哦
//        for (i in range){
//            println("$i="+i)
//        }

         //数组 Array 一列对象，一点儿关系都没有哦

        val  arrayInt:IntArray= intArrayOf(1,3,5,7)
        val  arrayCar:CharArray= charArrayOf('1','2','3','4')
        val  arrayString:Array<String> = arrayOf("string")

        val  arrBean :Array<TwoTwoBean> = arrayOf(TwoTwoBean("a","d","d"))

        println("打印数据的size哦" +arrayInt.size)
        for (i in arrayCar){
            println("$i="+i)
        }
        //替换赋值的问题  数组的角标也是从0开始的
        println(arrayCar[1])
        arrayCar[1]= '\u00ff'
        println(arrayCar[1])

        arrayCar.joinToString()

        //1, ÿ, 3, 4
        println(arrayCar.joinToString())
        //不要逗号的 分割 ,, ,, ,, ,
        println(arrayCar.joinToString(){","})
        //1ÿ34
        println(arrayCar.joinToString(""))
        //[ÿ, 3]  取出1和2角标的元素  切片
        println(arrayCar.slice(1..2))

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
                + HelloWorld::class.java.simpleName.slice(0 until helloWorldLength-2)) // [0, 11) 不包含 11啊
        println("the length of hello world is : " + helloWorldLength)
        println("the length of hello world is (long): " + helloWorldLengthLong)

        //变量的
        val mainTest:MainTest= MainTest()
        mainTest.toTest1()

        val lamdda: Lamdda=Lamdda()

        val gril=Gril("18","182kg","好看")
        gril.sing("爱我")

         val operatordemo= OperatorDemo(2.2,2.4)
         val operatordemo2= OperatorDemo(2.2,2.4)
        //重写 toString的方法
        println(operatordemo.plus(operatordemo2))//com.kotlin.demo.operator.OperatorDemo@a675f990
        //当 重写 写了toString的方法的话 4.4+4.8

        println(operatordemo.plus(55551))


        val expressoin= ExpressionDemo()
        //for循环的
        val ForDemo= ForDemo()

        val CatchDEmo= CatchDEmo()
        //具名参数 ，变成参数
        val ParameterDemo= ParameterDemo()

        val C=C()


        val ClassCanSeeDemo= ClassCanSeeDemo()

        val StaticDemo= StaticDemo()
        val OverLoads= OverLoads()
        OverLoads.a(1)
        OverLoads.a()//不传入的话 ，就相当 只调用一个函数

        val Extends= Extends()

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
