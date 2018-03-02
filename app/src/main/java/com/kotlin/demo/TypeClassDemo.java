package com.kotlin.demo;

/**
 * author： Created by shiming on 2018/3/2 10:42
 * mailbox：lamshiming@sina.com
 */

public class TypeClassDemo {
    public void getDemoCode(){
        TwoTwoBean.Parent child = new TwoTwoBean.Child();
        if (child instanceof  TwoTwoBean.Parent ){
            //如果需要使用的话，需要再次的转化，代码显得比较多余
            System.out.println("child" +(TwoTwoBean.Child)child);
        }

    }
}
