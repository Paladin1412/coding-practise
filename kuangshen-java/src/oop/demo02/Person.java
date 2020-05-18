package oop.demo02;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 21:16
 **/
public class Person {
    protected String name = "person";

    //父类不显示无参构造的话子类也不能
    //显示无参构造
    public Person(){

    }

    //私有无法被继承
    public void print(){
        System.out.println("Person");
    }
}
