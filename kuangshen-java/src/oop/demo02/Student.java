package oop.demo02;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 21:08
 **/
public class Student extends Person {
    private String name = "student";

    public Student() {
        //super(); 调用父类构造器必须在第一行
    }

    @Override
    public void print(){
        System.out.println("Student");
    }

    public void test1(){
        print();
        this.print();
        super.print();
    }

    public void go(){
        System.out.println("go");
    }

    public void test(String name) {
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
