package base;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-15 14:29
 **/
public class Demo3 {

    // 常量 final修饰符
    final static double PI = 3.14;

    // 类变量 static 如果不自行初始化 默认值
    static double salary = 2500;
    static double salary1;

    // 实例变量 从属于对象 如果不自行初始化 默认值
    // boolean 默认 false
    String name;
    int age;

    public static void main(String[] args) {

        //局部变量 必须声明和初始化
        int i=10;
        System.out.println(i);

        System.out.println("=============");
        Demo3 demo3 = new Demo3();
        System.out.println(demo3.age);  // 0
        System.out.println(demo3.name);  // null

        System.out.println("=============");
        System.out.println(salary);
        System.out.println(salary1); // 0.0

    }
}
