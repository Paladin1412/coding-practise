package com.wang.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Description: 饿汉式单例 多线程安全 但是不管怎么处理 只要没用枚举 反射都能破坏单例
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 13:44
 **/
public class SafeLazyMan {

    private SafeLazyMan(){

        //防止在反射的作用下不单例
        synchronized (LazyMan.class){
            if(lazyMan!=null){
                throw new RuntimeException("不要使用反射试图破坏单例");
            }
        }
    }

//    private static SafeLazyMan lazyMan;
    // 因为new SafeLazyMan()可能指令重排 所以为了避免指令重排导致return null 加volatile
    private volatile static SafeLazyMan lazyMan;


    //双重检测锁模式 DCL懒汉式
    public static SafeLazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan = new SafeLazyMan(); // 有可能指令重排
                    /**
                     * 分配内存空间
                     * 执行构造方法 初始化对象
                     * 把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    //原本的单例模式在反射的作用下不再单例
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LazyMan lazyMan1 = LazyMan.getInstance();
//        LazyMan lazyMan2 = LazyMan.getInstance();
//        System.out.println(lazyMan1.hashCode()); //116211441
//        System.out.println(lazyMan2.hashCode()); //116211441
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan3 = declaredConstructor.newInstance();
        System.out.println(lazyMan3.hashCode()); //1625635731
        LazyMan lazyMan4 = declaredConstructor.newInstance();
    }
}
