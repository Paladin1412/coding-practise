package com.wang.lambda;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 22:52
 **/
public class TestLambda1 {

    //静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        //局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        like = new Like3();
        like.lambda();

        //匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //lambda简化
        like = () -> {
            System.out.println("I like lambda5");
        };
        like.lambda();
    }
}

//定义一个函数式接口
interface ILike {
    void lambda();
}

//实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}