package base;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-15 13:55
 **/
public class Demo2 {
    public static void main(String[] args) {
        char c1 = 'a';
        char c2 = '中';

        int i1 = (int)c1;
        int i2 = (int)c2;

        System.out.println(c1+ "-----" + i1);
        System.out.println(c2+ "-----" + i2);

        //所有字符的本质是数字
        //编码 Unicode表：（A---65 a---97）

        // U0000------UFFFF

        char c3 = '\u0061';

        System.out.println(c3); //a

        // 转义字符
        // \t \n
    }
}
