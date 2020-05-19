package main.java.duck;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 15:33
 **/
public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
