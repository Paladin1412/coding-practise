package com.wang.reflection;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-21 11:06
 **/
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.wang.reflection.User");
        Class c2 = Class.forName("com.wang.reflection.User");
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        System.out.println(c1.hashCode()); //1639705018
        System.out.println(c2.hashCode()); //1639705018
    }
}

//实体类 pojo entity
class User {
    private String name;
    private int id;
    private int age;

    public User() {
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
