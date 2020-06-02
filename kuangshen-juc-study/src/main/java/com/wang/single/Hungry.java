package com.wang.single;

/**
 * @Description: 饿汉式单例 耗内存 原因：启动时就加载了 如果类中有耗费内存的对象就会浪费空间
 * @Author: wangyinghao_sx
 * @Date: 2020-05-26 13:39
 **/
public class Hungry {
    private Hungry() {

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance() {
        return HUNGRY;
    }
}
