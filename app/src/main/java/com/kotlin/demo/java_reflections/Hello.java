package com.kotlin.demo.java_reflections;

import java.lang.reflect.InvocationTargetException;


/**
 * author： Created by shiming on 2018/3/27 18:18
 * mailbox：lamshiming@sina.com
 */

public class Hello {

    public  void doSomething(){
        try {
            //调用静态是本身  如果是静态方法的话，传入null
            //如果不是静态的方法的话，就传入本身 所以需要加上一个null
//            Object invoke = JavaReflectionsKt.class.getDeclaredMethod("sayHello", Person.class).invoke(new Person("woshijavalimainde", 20));
            /**
             * java中可以访问到 kotlin中的方法
             * 但是kotlin中不能访问java的方法
             */
            Object invoke = JavaReflectionsKt.class.getDeclaredMethod("sayHello", Person.class).invoke(null,new Person("我是直接在java类中调用的哦", 20));

            JavaReflectionsKt.sayHelloMore("我是java中调用的");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
