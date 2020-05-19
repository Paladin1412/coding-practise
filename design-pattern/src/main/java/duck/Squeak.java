package main.java.duck;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 15:35
 **/
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
