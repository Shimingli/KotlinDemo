package com.kotlin.demo.star_demo

import org.jetbrains.annotations.NotNull
import java.lang.reflect.ParameterizedType

/**
 * author： Created by shiming on 2018/4/14 15:08
 * mailbox：lamshiming@sina.com
 */
//Mvp 中的V层 超级接口
interface IView<out P:Ipresenter<IView<P>>>{
    val presenter:P
}
//P层的超级接口
interface Ipresenter<out V:IView<Ipresenter<V>>>{
//    @NotNull
//    IView getView();
    val view:V
}

abstract class BaseView<out P:BasePresenter<BaseView<P>>>:IView<P>{
    override val presenter:P

    init {
        presenter= findPresenterClass().newInstance()
        presenter.view=this
    }

    /**
     * 得到相对于的Class的文件
     */
    private fun findPresenterClass():Class<P>{
        //不知道，使用星投影去接收  相当于  Class thisClass = this.getClass();
        var thisClass:Class<*> = this.javaClass
//        while(true) {
//            Type var10000 = thisClass.getGenericSuperclass();
//            if(!(var10000 instanceof ParameterizedType)) {
//                var10000 = null;
//            }
//            ParameterizedType var5 = (ParameterizedType)var10000;
//            if(var5 != null) {
//                Type[] var6 = var5.getActualTypeArguments();
//                if(var6 != null) {
//                    var10000 = (Type)ArraysKt.firstOrNull((Object[])var6);
//                    if(var10000 != null) {
//                        Type var2 = var10000;
//                        if(var2 == null) {
//                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<P>");
//                        }
//
//                        return (Class)var2;
//                    }
//                }
//            }
//        }
        //以下的代码相当于上面的代码
        while (true){
            (thisClass.genericSuperclass as? ParameterizedType)
                    ?.actualTypeArguments
                    ?.firstOrNull()
                    ?.let {
                        return it as Class<P>
                    }?.run{
                            thisClass=thisClass.superclass ?:throw IllegalAccessException()
                        }
                    }
        }

    }


abstract class BasePresenter<out V:IView<BasePresenter<V>>>:Ipresenter<V>{
    //lateinit 延迟初始化
    //@UnsafeVariance 告诉编译器 我很安全 不要管我
    override lateinit var view:@UnsafeVariance V
}

class MainView:BaseView<MainPresenter>()

class MainPresenter:BasePresenter<MainView>()

class Mvp{
    init {
        MainView().presenter.let(::println)
        //相当于下面的代码
//        BasePresenter var1 = (new MainView()).getPresenter();
//        System.out.println(var1);
        MainView().presenter.let { println("shiming P="+it) }
        //相当于下面的代码
//        var1 = (new MainView()).getPresenter();
//        MainPresenter it = (MainPresenter)var1;
//        String var3 = "shiming P=" + it;
//        System.out.println(var3);
//        (new MainPresenter()).getView();

    }
}