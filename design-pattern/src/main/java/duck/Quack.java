package main.java.duck;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 15:35
 **/
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
