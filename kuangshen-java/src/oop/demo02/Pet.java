package oop.demo02;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 21:30
 **/
public class Pet {

    // 赋初始值
    {
        System.out.println("匿名代码块");
    }

    //静态代码块只执行一次
    static {
        System.out.println("静态代码块");
    }

    public Pet() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        new Pet();
        System.out.println("=======");
        new Pet();
    }
}
