package main.java.duck;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 15:54
 **/
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
