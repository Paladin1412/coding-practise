package thread.runnable;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-08 13:46
 **/
public class Demo {
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }

    public static void main(String[] args) {
        new MyThread().run();

        // Java 8 函数式编程，可以省略MyThread类
        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();

        new Thread(() -> {
            System.out.println("test");
        }).start();
    }
}
