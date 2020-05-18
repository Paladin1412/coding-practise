package scanner;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 01:17
 **/
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("使用next方式接收");

        //判断用户有没有输入字符串
        if (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println("输入的内容为" + next);
        }

        scanner.close();
    }
}
