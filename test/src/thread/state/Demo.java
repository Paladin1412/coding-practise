package thread.state;

import org.junit.Test;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-09 10:08
 **/
public class Demo {
    @Test
    public void testStartNew() {
        Thread thread = new Thread(() -> {
        });
        System.out.println(thread.getState()); //输出NEW 未调用start方法
        thread.start();
        System.out.println(thread.getState());
    }

    @Test
    public void testBlocked() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
        a.start();
        a.join();
//        Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
