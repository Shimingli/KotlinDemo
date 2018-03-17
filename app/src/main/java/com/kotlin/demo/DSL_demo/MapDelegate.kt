package com.kotlin.demo.DSL_demo

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * author： Created by shiming on 2018/3/17 16:18
 * mailbox：lamshiming@sina.com
 *
 * 集合的代理的东西  可用于实现读写属性的属性委托的基接口。ReadWriteProperty
 */
class MapDelegate(val map:MutableMap<String,String>):ReadWriteProperty<Any,String>{
    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name]=value
    }
    /**
     * 有可能返回为null 就是直接返回一个 “”字符串
     */
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
         return map[property.name]?:""
    }

}