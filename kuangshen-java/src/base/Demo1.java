package base;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-15 13:45
 **/
public class Demo1 {
    public static void main(String[] args) {

        // float 有限 离散 舍入误差 大约 接近但不等于
        // 最好完全避免使用浮点数进行比较
        // 使用BigDecimal 数学工具类 如 银行业务
        float f = 0.1f;
        double d = 1.0 / 10;

        System.out.println(f == d);  // false
        System.out.println(f);
        System.out.println(d);

        System.out.println("=============");

        float d1 = 2333333333333f;
        float d2 = d1 + 1;
        System.out.println(d1 == d2);  // true
    }
}
