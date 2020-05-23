package com.wang.reflection;

/**
 * @Description: 测试Class类的创建方式有哪些
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 11:13
 **/
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);  //Student

        //方式一 通过对象获得
        Class c1 = person.getClass();

        //方式二 forName获得
        Class c2 = Class.forName("com.wang.reflection.Student");

        System.out.println(c1.hashCode());  //1639705018
        System.out.println(c2.hashCode());  //1639705018

        //方式三 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());  //1639705018

        //方式四 基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;

        //获得父类的类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

class Student extends Person {
    public Student() {
        this.name = "Student";
    }
}

class Teacher extends Person {
    public Teacher() {
        this.name = "Teacher";
    }
}