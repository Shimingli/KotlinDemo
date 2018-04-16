package com.kotlin.demo.generics;

/**
 * author： Created by shiming on 2018/4/16 16:58
 * mailbox：lamshiming@sina.com
 */

public class Raw<T> {
    @Override
    public String toString() {
        return "老子是Raw";
    }
    public static Raw getRaw(){
        return new Raw();
    }
}
