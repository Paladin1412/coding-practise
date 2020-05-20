package com.wang.lambda;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 23:08
 **/
public class TestLambda2 {

    public static void main(String[] args) {
//        ILove love=(int a)->{
//            System.out.println("I love u " + a);
//        };

//        //简化1：去掉参数类型
//        ILove love = (a) -> {
//            System.out.println("I love u " + a);
//        };

//        //简化2：简化括号
//        ILove love = a -> {
//            System.out.println("I love u " + a);
//        };

        //简化3：简化花括号
        ILove love = a ->
                System.out.println("I love u " + a);

        //总结：
        //lambda有一行代码的情况下才能简化成一行
        //前提是接口是函数式接口
        //多个参数也可以去掉参数类型 必须加上括号
    }
}

interface ILove {
    void love(int a);
}
