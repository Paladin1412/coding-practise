package thread.threadDemo04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 通过线程池创建线程
 * @Author: wangyinghao_sx
 * @Date: 2019-11-08 20:48
 **/
public class ThreadDemo4 {
    private static int POOL_NUM = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < POOL_NUM; i++) {
            RunnableThread thread = new RunnableThread();
            Thread.sleep(1000);
            executorService.execute(thread);
            // 或者通过submit提交callable或者runnable接口的实现类
            // Future<Boolean> future = threadPool.submit(task);
        }
        executorService.shutdown();
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");
    }
}
