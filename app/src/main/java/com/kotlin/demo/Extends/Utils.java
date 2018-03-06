package com.kotlin.demo.Extends;

import android.text.TextUtils;

/**
 * author： Created by shiming on 2018/3/6 15:26
 * mailbox：lamshiming@sina.com
 */

public class Utils {
    public static boolean  doS(String[] strings){
        return strings.length==0;
    }
    public static boolean  doSisEm(String strings){
        return TextUtils.isEmpty(strings);
    }
}
