package thread.threadDemo02;

/**
 * @Description: 实现Runnable接口，重写run方法，实现Runnable接口的实现类的实例对象作为Thread构造函数的target，没有返回值
 * @Author: wangyinghao_sx
 * @Date: 2019-11-08 15:48
 **/
public class ThreadDemo02 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new MyThread());
        t1.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->我是通过实现接口的线程实现方式");
    }
}
