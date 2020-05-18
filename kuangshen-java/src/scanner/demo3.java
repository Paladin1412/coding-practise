package scanner;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 01:23
 **/
public class demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i=0;
        float f = 0.0f;

        System.out.println("请输入整数");

        if(scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数" +i);
        }else{
            System.out.println("不整数");
        }

        System.out.println("请输入小数");
        if(scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("小数" +f);
        }else{
            System.out.println("不小数");
        }

        scanner.close();
    }
}
