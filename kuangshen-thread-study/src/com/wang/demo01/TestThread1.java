package com.wang.demo01;

/**
 * @Description: 创建线程方式一 继承Thread类 重写run()方法 调用start开启线程
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 14:50
 **/
//线程开启不一定立即执行，由cpu调度执行
public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----" + i);
        }
    }

    public static void main(String[] args) {
        TestThread1 testThread1 = new TestThread1();

        testThread1.start();  //start会和主线程交替执行
        testThread1.run();  //先执行run 再执行主线程
        //main线程 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习----" + i);
        }
    }
}
