package oop.demo03;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 23:30
 **/
public abstract class Action {

    //abstract 抽象方法 只有方法名字 没有方法的实现
    public abstract void doSomething();

    // 不能new这个抽象类 只能靠子类去实现
    // 抽象类中可以写普通方法
    // 抽象方法必须在抽象类中

    // 思考 抽象类不能new 那么存在构造器么：存在
}
