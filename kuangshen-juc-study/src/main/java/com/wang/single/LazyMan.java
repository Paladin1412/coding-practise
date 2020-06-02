package com.wang.single;

/**
 * @Description: 饿汉式单例 单线程有效 多线程存在问题
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 13:44
 **/
public class LazyMan {

    private LazyMan(){

    }

    private static LazyMan lazyMan;

    public static LazyMan getInstance(){
        if(lazyMan==null){
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }
}
