package com.wang.reflection;

import java.lang.annotation.ElementType;

/**
 * @Description: 所有类型的Class
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 11:39
 **/
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;//类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//一维数组
        Class c4 = int[][].class;//二维数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;//基本数据类型包装类
        Class c8 = int.class;//基本数据类型
        Class c9 = void.class;//void
        Class c10 = Class.class;//Class

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
        System.out.println(c10);

    }
}
