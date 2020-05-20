package com.wang.lock;

/**
 * @Description: 测试生产者消费者模型--->利用缓冲区解决：管程法
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 17:54
 **/
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }

}

class Productor extends Thread {
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.pop();
        }
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    //一个容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            //通知消费者消费 生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count++] = chicken;
        System.out.println("生产了第" + chicken.id + "只鸡");
        //通知消费者消费
        this.notifyAll();
    }

    public synchronized void pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Chicken chicken = chickens[--count];
        System.out.println("消费了第" + chicken.id + "只鸡");
        this.notifyAll();
    }
}
