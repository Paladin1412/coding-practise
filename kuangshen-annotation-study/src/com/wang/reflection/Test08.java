package com.wang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Description: 获得类的信息
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 21:40
 **/
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c1 = Class.forName("com.wang.reflection.User");

        //获得类的名字
        System.out.println(c1.getName()); //获得包名+类名 com.wang.reflection.User
        System.out.println(c1.getSimpleName());//获得类名 User

        //获得类的属性
        System.out.println("===============");
        Field[] fields = c1.getFields(); //获取public的属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===============");
        fields = c1.getDeclaredFields();//找到全部属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("===============");
        //获得类的方法
        Method[] methods = c1.getMethods(); //获得本类及其父类的全部public方法
        for (Method method : methods) {
            System.out.println(method);
        }
        methods = c1.getDeclaredMethods(); //获得本类的所有方法
        for (Method method : methods) {
            System.out.println(method);
        }

        //获得指定方法
        //重载
        Method getName = c1.getMethod("getName");
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        Constructor[] constructors = c1.getConstructors();
        constructors = c1.getDeclaredConstructors();

        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
    }
}
