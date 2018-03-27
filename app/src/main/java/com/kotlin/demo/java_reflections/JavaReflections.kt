package com.kotlin.demo.java_reflections

/**
 * author： Created by shiming on 2018/3/27 16:06
 * mailbox：lamshiming@sina.com
 */
class JavaReflections{
    init {
//           Class java = Person.class; 等于下面的 防范
        val java = Person::class.java
//           Person person = new Person("shiming", 18);
//        Class var3 = person.getClass(); 等于下面的方法
        val person = Person("shiming", 18)
        val javaClass = person.javaClass
        //      Class var4 = person.getClass();
        val java1 = person::class.java

//        Caused by: java.lang.InstantiationException: can't instantiate class com.kotlin.demo.java_reflections.Person; no empty constructor
        //这里直接会报错，因为这里调用的无参构造的方法
        //但是这个 person类是没有无参构造方法的 ，所以直接报错了
//       val person2=javaClass.newInstance()
        //这样就不会报错了 ，因为这里有无参构造的方法
        val defaulltCostructor = DefaulltCostructor::class.java.newInstance()

        val newInstance = javaClass.getConstructor(String::class.java, Int::class.java).newInstance("die", 20)
        println("shiming"+newInstance)
        //获取这个newInstance中的名字
        //下面的代码异常了
        // Caused by: java.lang.IllegalAccessException: access to field not allowed
       // val name = javaClass.getDeclaredField("name").get(newInstance)
        /**
         * 改后的代码 name是final的
         * 在java的反射使用中,如果字段是私有的,那么必须要对这个字段设置
         * field.setAccessible(true)
         * apply {  isAccessible=true}  就是告诉java运行时，不要管我，我就要访问
        Field var8 = javaClass.getDeclaredField("name");
        var8.setAccessible(true);
         */
        val name = javaClass.getDeclaredField("name").apply {  isAccessible=true}.get(newInstance)

        println("shiming "+name)
        /**
       Object age = javaClass.getDeclaredMethod("getAge", new Class[0]).invoke(newInstance, new Object[0]);
        String var9 = "shiming age" + age;
         */
        val age = javaClass.getDeclaredMethod("getAge").invoke(newInstance)
        println("shiming age"+age)
        //访问 copy方法 得到一个类
        val person2 = javaClass.getDeclaredMethod("copy",String::class.java,Int::class.java).invoke(newInstance,"woaini",22)
        println("shiming person2"+person2)  //person2Person(name=woaini, age=22)
        /**
         * javaClass 是person类的字节码文件，通过字节码文件修改person类中的name的值
         * 所以这里是通过反射修改val中的值 ，大概是这样的哦
         */
        javaClass.getDeclaredField("name").apply { isAccessible=true }.set(person,"feiji")
         println("shiming 改完名字后 "+person)

        person.sayHello()

        //反射拿到这个方法 java 例子
        val helloText= Hello()
        helloText.doSomething()
        // 联调完了

        //但是在koltin中访问不到 ，好气啊 但是能在里面调用
//        JavaReflectionsKt Person("我是在kotlin中调用的",25)
        Class.forName("com.kotlin.demo.java_reflections.JavaReflectionsKt")
                .getDeclaredMethod("sayHello",Person::class.java)
                .invoke(null,Person("我是在kotlin中调用的",25))
        //@com.kotlin.demo.java_reflections.Poko2()  反射拿到注解
        javaClass.getAnnotation(Poko2::class.java).let {  println("shiming "+it)}
        //java 1.8 后可以拿到重复的注解，因为1.8后，java可以重复的注解了
        //javaClass.getAnnotationsByType()

        javaClass.getDeclaredField("name").annotations.forEach {
            println("shiming 来了=="+it)
        }

        javaClass

    }
}
//data 类帮我们生成一个  toString的方法
@Poko2
data class Person(@JvmField val name:String, val  age:Int)

class DefaulltCostructor()

fun Person.sayHello(){
    println("shiming sayhello$name"+name +"------>$age"+age)
}
fun sayHelloMore(string: String){
    println("shiming sayHelloMore"+string)
}