package scanner;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 01:27
 **/
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;

        int m = 0;

        while (scanner.hasNextDouble()) {
            double v = scanner.nextDouble();
            m++;
            sum += v;
        }
        System.out.println("sum  " +sum);
        System.out.println("m  " +m);

        scanner.close();
    }
}
