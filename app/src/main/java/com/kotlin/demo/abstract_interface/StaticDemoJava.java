package com.kotlin.demo.abstract_interface;

/**
 * author： Created by shiming on 2018/3/6 14:41
 * mailbox：lamshiming@sina.com
 */

public class StaticDemoJava {
    public static void doS(){
        //java中取使用
        Latitude latitude = Latitude.Companion.ofDouble(154.24);//

         Latitude.ofDouble(15.22);

        String tag = Latitude.TAG;

        //
        OverLoads overLoads = new OverLoads();
        overLoads.a();//必须传入 参数   那边加上了一个 标记这样才能不传入参数   JvmOverloads
    }
}
