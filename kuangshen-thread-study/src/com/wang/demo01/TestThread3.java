package com.wang.demo01;

/**
 * @Description: 实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 15:19
 **/
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----" + i);
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();

//        Thread thread = new Thread(testThread3);
//        thread.start();

        //创建线程对象 通过线程对象开启线程 代理
        new Thread(testThread3).start();
        //main线程 主线程
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习----" + i);
        }
    }
}
