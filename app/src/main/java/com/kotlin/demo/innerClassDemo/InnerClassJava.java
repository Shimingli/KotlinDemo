package com.kotlin.demo.innerClassDemo;

/**
 * author： Created by shiming on 2018/3/7 14:21
 * mailbox：lamshiming@sina.com
 */

public class InnerClassJava {
    private int a;

    public class Inner{
        public void hello(){
            //下面的两种的方法是一样的哦
            System.out.println(a);
            System.out.println(InnerClassJava.this.a);

        }
    }

    public static class Inner1{
       public void hello(){
           //访问不到 外面的实例的对象
           //System.out.println(a);
           //注意这里  也访问不到
          // System.out.println(InnerClassJava.this.a);
       }
    }



    public void demo(){
        //java zhong 使用的内部类
        InnerClassJava innerClassJava = new InnerClassJava();
        Inner inner = innerClassJava.new Inner();
        //需要静态就可以了哦
        Inner1 inner1 = new Inner1();

    }
}
