package operator;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 00:40
 **/
public class Demo2 {
    public static void main(String[] args) {
        long a = 11111111111111111L;
        int b = 233;
        short c = 10;
        byte d =8;
        double e = 10;

        System.out.println(a+b+c+d+e); //double
        System.out.println(a+b+c+d);  // long
        System.out.println(b+c+d); //int
        System.out.println(c+d);  //int
    }
}
