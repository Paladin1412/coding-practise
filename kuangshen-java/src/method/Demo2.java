package method;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 10:31
 **/
public class Demo2 {
    public static void main(String[] args) {
        new Demo2().test(1,2,3,4,5);
    }

    public void test(int...i){
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }
}
