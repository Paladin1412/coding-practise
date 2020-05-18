package oop.demo05;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 23:54
 **/
public class Outer {

    private int id;

    public void out() {
        System.out.println("这是out的方法");
    }

    public void method(){

        // 方法里是局部内部类
        class B{

        }
    }

    // 成员内部类
    class Inner {
        public void in() {
            System.out.println("这是in的方法");
        }

        public void getID() {
            System.out.println(id);
        }
    }
}


// A不是内部类
class A{

}
