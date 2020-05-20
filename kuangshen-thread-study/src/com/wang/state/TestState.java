package com.wang.state;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 10:07
 **/
public class TestState {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("===========");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state); //NEW

        thread.start();
        state = thread.getState();
        System.out.println(state); //RUNNABLE

        while (state!=Thread.State.TERMINATED){
            try {
                Thread.sleep(100);
                state = thread.getState();
                System.out.println(state); //TIMED_WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        thread.start(); 线程死亡之后不能再调用start
    }
}
