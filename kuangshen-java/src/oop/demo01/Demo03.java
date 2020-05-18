package oop.demo01;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 14:22
 **/
public class Demo03 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name); //null
        Demo03.change(person);
        System.out.println(person.name); //test
    }

    public static void change(Person person) {
        person.name = "test";
    }
}

class Person {
    String name;
}
