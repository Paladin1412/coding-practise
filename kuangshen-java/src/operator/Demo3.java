package operator;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 00:43
 **/
public class Demo3 {
    public static void main(String[] args) {
        // ++ -- 一元运算符
        int a = 3;
        int b = a++;
        int c = ++a;

        System.out.println(a); //5
        System.out.println(b); //3
        System.out.println(c); //5
    }
}
