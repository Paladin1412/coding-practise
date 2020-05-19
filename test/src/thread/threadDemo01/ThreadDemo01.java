package thread.threadDemo01;

/**
 * @Description: 继承Thread类，重写run方法，没有返回值
 * @Author: wangyinghao_sx
 * @Date: 2019-11-08 15:30
 **/
public class ThreadDemo01 extends Thread {
    public ThreadDemo01() {
        // 编写子类的构造方法，可缺省
    }

    @Override
    public void run() {
        // 编写自己的线程代码
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        threadDemo01.setName("我是自定义的Thread1");
        threadDemo01.start();
        System.out.println(Thread.currentThread().toString());
    }
}
