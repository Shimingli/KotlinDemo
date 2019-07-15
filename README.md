# Kotlin总结
* **欢迎关注我的公众号**
![公众号](https://upload-images.jianshu.io/upload_images/5363507-de80ef2503c3072c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![狗熊镇楼](https://upload-images.jianshu.io/upload_images/5363507-f083ce7660bdceb8.gif?imageMogr2/auto-orient/strip)


*  **上周和两个大牛出去吃饭喝酒，谈到了Kotlin上面的知识，虽然已经在工程中开始运用了，但是，还是有好多的知识点不太熟悉，先做此文以表心迹！**

___


![kotlin爸爸](https://upload-images.jianshu.io/upload_images/5363507-8901e0879f6986c8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
___
* *为什么选择kotlin？官方的解释如下*
* *1、简洁：大大的减少样板代码的数量*
使用一行代码创建一个包含 `getters、 setters、 equals()、 hashCode()、 toString() 以及 copy() 的 POJO`
```
data class Customer(val name: String, val email: String, val company: String)
```
使用 lambda 表达式来过滤列表：
`val positiveNumbers = list.filter { it > 0 }`

想要单例？创建一个 object 就可以了：
`object ThisIsASingleton {
    val companyName: String = "JetBrains"
}
`



* *2、安全：避免空指针异常等这个类的错误*

彻底告别那些烦人的 NullPointerException——著名的[十亿美金的错误](http://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare)。
* Null References: The Billion Dollar Mistake

编译错误?为什么呢？因为定义的时候就告诉他不能为null了，是个String类型
```
var output: String
output = null   // 编译错误
```
Kotlin 可以保护你避免对可空类型的误操作
```
val name: String? = null    // 可控类型
println(name.length())      // 编译错误
```
并且如果你检查类型是正确的，编译器会为你做自动类型转换
```
fun calculateTotal(obj: Any) {
    if (obj is Invoice)
        obj.calculateTotal()
}
```

* *3、互操作性，充分利用JVM、Android和浏览器现有的库*
使用 JVM 上的任何现有库，因为有 100％ 的兼容性，包括 SAM 支持。
```
   Flowable
            .fromCallable {
                Thread.sleep(1000) //  模仿高开销的计算
                "Done"
            }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe(::println, Throwable::printStackTrace)
```
无论是 JVM 还是 JavaScript 目标平台，都可用 Kotlin 写代码然后部署到你想要的地方
```
import kotlin.browser.window

fun onLoad() {
    window.document.body!!.innerHTML += "<br/>Hello, Kotlin!"
}
```
* *4、工具友好：可用任何 Java IDE 或者使用命令行构建。*
JetBrains 提供所有支持

####  Kotlin主要用于：使用 Kotlin 进行服务器端开发、使用 Kotlin 进行 Android 开发、使用 Kotlin 进行 Kotlin JavaScript 开发、Kotlin/Native 用于原生开发

>Kotlin 非常适合开发 Android 应用程序，将现代语言的所有优势带入 Android 平台而不会引入任何新的限制
>>> * 兼容性
>>>Kotlin 与 JDK 6 完全兼容，保障了 Kotlin 应用程序可以在较旧的 Android 设备上运行而无任何问题。Kotlin 工具在 Android Studio 中会完全支持，并且兼容 Android 构建系统
>>> * 性能
>>>由于非常相似的字节码结构，Kotlin 应用程序的运行速度与 Java 类似。 随着 Kotlin 对内联函数的支持，使用 lambda 表达式的代码通常比用 Java 写的代码运行得更快。
>>> * 互操作性
>>>Kotlin 可与 Java 进行 100％ 的互操作，允许在 Kotlin 应用程序中使用所有现有的 Android 库 。这包括注解处理，所以数据绑定与 Dagger 也是一样
>>>* 占用
>>>Kotlin 具有非常紧凑的运行时库，可以通过使用 ProGuard 进一步减少,Kotlin 运行时只增加几百个方法以及 .apk 文件不到 100K 大小。
>>>* 编译时长
>>>Kotlin 支持高效的增量编译，所以对于清理构建会有额外的开销，[增量构建通常与 Java 一样快或者更快](https://medium.com/keepsafe-engineering/kotlin-vs-java-compilation-speed-e6c174b39b5d)。






* ****
* **1、** **Kotlin**是一种在Java虚拟机上运行的静态类型的编程语言
* JVM（英语：Java Virtual Machine，缩写为JVM），一种能够运行Java bytecode（.class）的虚拟机，以堆栈结构机器来进行实做。Java虚拟机有自己完善的硬体架构，如处理器、堆栈、寄存器等，还具有相应的指令系统。JVM屏蔽了与具体操作系统平台相关的信息，使得Java程序只需生成在Java虚拟机上运行的目标代码，就可以在多种平台上不加修改地运行。

* 静态类型语言`（C#、java）`：如果一个编程语言的类型检查，可在不测试运行时期表达式的等价性的情况下进行，该语言即为静态语言，静态类型的编译语言，是在运行期间和编译期间之间的处理阶段下重视这些区别的。说通俗一点，就是在编译阶段（运行前判断）
* 动态类型语言（Python、Ruby、Perl）：官方的定义：一个编程语言支持在运行时期调度已标记的数据。通俗一点就是，类型的检查食在运行时期做的，判断代码是否合法也是在运行时才判断

* 其他的知识：
 a、俄罗斯圣彼得堡的JetBrains开发团队所发展出来的编程语言

  b、2011年7月，JetBrains推出Kotlin项目

  c、Jetbrains希望这个新语言能够推动IntelliJ IDEA的销售

  d、Kotlin v1.0于2016年2月15日发布
  e、在Google I/O宣布在Android上为Kotlin提供最佳支持。

   f、Kotlin很明显受到Java、C#、JavaScript、Scala、Groovy等语言的影响



* **2、**常量与变量
使用`val`（全称为value，即（固定的）值）关键字定义常量，定义后其值无法修改
```
//定义a为int类型的变量，值为1
val a:Int=1
//自动检查b为int的类型
val b=2

```
使用`var`（全称为variable，即变量）关键字定义变量。
```
//定义x的值为5
var x = 5 
//修改x的值为1
x=1
```

* **3、**函数
使用fun关键字定义一个函数。
```
fun sum(a: Int, b: Int): Int {
    return a + b
}
```


* **4、**Main 进入点.Kotlin的main函数是不依赖类的，所以main函数是一个top-level函数

什么是top-level的函数：在Java中必须有类才有main函数，在kotlin中，main函数可以不依赖于类
```
fun main(args: Array<String>) {
    println("shiming  我是 topLevel 函数")
}
```
在使用kotlin的写安卓的时候，main函数不会主动的运行，所以基本上不会使用到这个方法

使用单利：使用object来声明一个类时，表示这是一个单例类，一般和lazy想结合这使用
* *在一个类中，lazy的方法执行实际要先于init之前，如果init有使用到lazy方法中的初始化的对象*

* *在一个kotlin类中，init方法可以有很多个，会按照init出现的顺序取初始化，但是建议一个类还有只有一个init方法比较好*
![image.png](https://upload-images.jianshu.io/upload_images/5363507-f73758d930f22b72.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
图中的日志可以看到日志输出的详情


* **5、函数扩展**
Kotlin与C#、JavaScript类似，能够扩展类别的新功能，而无需继承该类别，或使用像装饰器（decorator）这样的任何类型的设计模式（design pattern）。说通俗一点，就是我们能够增加某个类的方法，而不用去继承这个类
```
    fun String.lastChar(): Char = get(length - 1)
```

![](https://upload-images.jianshu.io/upload_images/5363507-67b7e29e58758188.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/5363507-7a4eaa53a2fa25c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

利用函数扩展，Kotlin也支持运算符重载
![](https://upload-images.jianshu.io/upload_images/5363507-c9c7938e4675cab6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/5363507-f722fa935ada0abc.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* **6、getter和setter**
Kotlin像C#一样支持属性（property）。

* **7、解包引数**
类似Python, 解包（unpack）指的是对实际参数的解包，只需在前面加一个星号* 即可，如test（*a）:
```
fun main(args: Array<String>) { 
        val list = listOf("args: ", *args)
        println(list)
    }
```

* **8、函数嵌套**
Kotlin支持函数嵌套（nested functions），允许函数内再定义函数，类似JavaScript、C#与Python语言。
```
  class User(
        val id:      Int, 
        val name:    String, 
        val address: String) 
    { 

        fun saveUser(user: User) {
           fun validate(user: User, value: String, fieldName: String) {
               if (value.isEmpty()) {
                   throw IllegalArgumentException(
                      "Can't save user ${user.id}: empty $fieldName")
               }
           }

           validate(user, user.name, "Name") 
           validate(user, user.address, "Address")
           // Save user to the database
        }
    }
```

* **9、解构声明**
Kotlin支持解构声明，这与Python的迭代解包相似。就是for循环，官方说的太笼统了

```
  for ((index, element) in collection.withIndex()) { 
         println("$index: $element")
    }
```

* **10、抽象类别**
抽象类别（Abstract classes）定义抽象或纯虚拟（Pure Virtual）占位函数，需要被继承。抽象类别默认是open的。
```
 // 不需要open。默认就是的
    abstract class Animated {

        // This virtual function is already open by default as well
        abstract fun animate()
  
        open fun stopAnimating() { }

        fun animateTwice() { }
    }
```

* **11、类别属性**
Kotlin 提供下列的关键字来限制顶层（top-level）声明，用于控制类别与成员在继承时的可见性（作用域）。
>>* public:全局可见。此为默认的类型。
>> * internal:在当前模块中可见
>>* protected:在当前类别的一级子类中可见，如果子类再被继承，则在下一级子类中不可见。
>>* private:在当前类别中可见。

* **12、主构造函数 vs. 二级构造函数**
在Kotlin 中类别可以有一个主构造函数以及多个二级构造函数。如果主构造函数没有注解或可见性说明，则constructor关键字可以省略。如果构造函数中没有其它操作，大括号也可以省略。
```
class User(
         val nickname: String, 
         val isSubscribed: Boolean = true) 
     {
         ...
     }
```
Kotlin 的二级构造函数更类似于 C++, C#, 和 Java。
```
 class MyButton : View {

        // Constructor #1 
        constructor(ctx: Context) : super(ctx) { 
            // ... 
        } 
  
        // Constructor #2
        constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) { 
            // ... 
        }
    }
```

* **13、Anko library**
Anko 是一组为Kotlin 打造的函数库，其功能是用来开发Android UI 应用程序。但是我基本上不用,我觉得这个好怪，不过以后真的都在使用了，我肯定会尝试一下

```
 fun Activity.showAreYouSureAlert(process: () -> Unit) {
            alert(
              title   = "Are you sure?",
              message = "Are you really sure?") 
            {
              positiveButton("Yes") { process() }
              negativeButton("No") { cancel() }
            }
        }
```

* **14、Kotlin 交互模式**
Kotlin除了编译成Java字节码运行，也可以作为脚本语言解释运行，此特性使得Kotlin可以以交互模式运行。交互模式是脚本语言具有的特性，解释器可以立即运行用户输入的代码，并反馈运行结果。典型的语言有Python、JavaScript（在V8引擎支持下）、Ruby。
```
$ kotlinc-jvm
type :help for help; :quit for quit
>>> 2+2
4
>>> println("Welcome to the Kotlin Shell")
Welcome to the Kotlin Shell
>>>
```

* **15、Kotlin 也是脚本语言**
Kotlin 亦可视为脚本语言（scripting language）。其脚本存成 Kotlin source file (.kts)，即成为可执行档。
```
// list_folders.kts
import java.io.File
val folders = File(args[0]).listFiles { file -> file.isDirectory() }
folders?.forEach { folder -> println(folder) }
```
为了运行Kotlin 脚本，我们在运行编译器时再加上-script选项。
```
$ kotlinc -script list_folders.kts "path_to_folder_to_inspect"
```


* **16、空变量及其运算**
Kotlin对可以为空（nullable）的变量和不可以为空（non-nullable）的变量作了区分。所有的可空对象（nullable objects）必须在定义时加上 "?" 后置于类型之后。开发人员遇到nullable objects时要先确认: null-check 须被运行过，才能赋值。可空性是Kotlin类型系统中帮助开发者避免以往Java的[NullPointerException](https://zh.wikipedia.org/wiki/NullPointerException "NullPointerException")错误的特性。
*   ?. 可用于安全访问（safely access） 可能是空对象的函数或属性。如果 object 为空（null）, the method 将不被调用，而且表达式必运算（evaluate）为空（null）。
*   ?: 经常引用到艾维斯运算符（Elvis operator）:
```
fun sayHello(maybe: String?, neverNull: Int) {
   // use of elvis operator
   val name: String = maybe ?: "stranger"
   println("Hello $name")
}
```
使用安全导引（safe navigation）运算符:
```
foo()?.bar()?.baz()
```

* **17、高阶函数与lambda**
Kotlin 亦支持高阶函数和lambdas功能。lambda是一种匿名函数，允许开发者直接将表达式定义为函数，这类似于Python。
```
  fun executeLambda(f: (s: String) -> Unit) {
    f("lambda")
  }
```
Lambdas 可用大括弧{ } 来定义。如果lambda 夹带参数，他们可定义在大括弧内，并以->运算符区隔。
```
  val l = { c : Any? -> println(c) }
  val l2 = { print("no parameters") }
```


> * **总结**
>> *  **[Kotlin学习Demo](https://github.com/Shimingli/KotlinDemo)**
>> * 一个kotlin的类可以有很多的init方法，init方法肯定会执行，这个类在初始化的时候，但是main不一定，main方法是top-level函数，可以不依托类
>> * kotlin中的init和main可以和Go对比，其实都是差不多的
>>* 运行在JVM上的语言：Clojure、Groovy（作为Java平台的脚本语言使用）、Java、Kotlin、Scala
>>* 运行在Android上的：Java、Kotlin、C++



![qrcode_for_gh_9bd8e7d248a8_258.jpg](https://upload-images.jianshu.io/upload_images/5363507-dfaf0e3d9a2852ec.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

