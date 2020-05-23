package com.wang.reflection;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 14:23
 **/
public class Test05 {
    public static void main(String[] args) {
        System.out.println(A.m);
        A a = new A();
        System.out.println(A.m);
    }
}

class A {

    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;



    public A() {
        System.out.println("A类的无参构造");
    }
}
