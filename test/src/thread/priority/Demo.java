package thread.priority;

import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-08 17:05
 **/
public class Demo {
    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d, 线程组: %s",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority(),
                    Thread.currentThread().getThreadGroup().getName()));
        }
    }

    public static void main(String[] args) {
        System.out.println("main:" + Thread.currentThread().getName());
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }
}