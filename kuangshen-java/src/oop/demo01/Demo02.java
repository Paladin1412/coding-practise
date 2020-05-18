package oop.demo01;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 14:21
 **/
public class Demo02 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);  // 1
        Demo02.change(a);
        System.out.println(a); // 1
    }

    public static void change(int a) {
        a = 10;
    }
}
