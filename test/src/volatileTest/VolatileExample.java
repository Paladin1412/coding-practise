package volatileTest;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-04-13 14:57
 **/
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1; // step 1
        flag = true; // step 2
    }

    public void reader() {
        if (flag) { // step 3
            System.out.println(a); // step 4
        }
    }
}
