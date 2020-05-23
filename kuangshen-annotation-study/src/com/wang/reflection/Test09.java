package com.wang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 通过反射动态创建对象
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 22:20
 **/
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.wang.reflection.User");

        //构造一个对象
        User user = (User) c1.newInstance(); //本质是调用了类的无参构造

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) constructor.newInstance("A", 10, 10);

        //通过反射调用普通方法
        User user2 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user2, "B");
        System.out.println(user2.getName());

        //通过反射操作属性
        User user3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性 需要关闭程序的安全检测 name.setAccessible(true);
        name.setAccessible(true);
        name.set(user3, "C");
        System.out.println(user3.getName());
    }
}
