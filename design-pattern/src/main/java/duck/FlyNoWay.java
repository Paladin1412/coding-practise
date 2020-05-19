package main.java.duck;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 15:37
 **/
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
