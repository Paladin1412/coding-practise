package scanner;

import java.util.Scanner;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 01:48
 **/
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        switch (nextLine){
            case "爸爸":
                System.out.println("爸爸");
                break;
            default:
                System.out.println("不是爸爸");
        }
    }
}
