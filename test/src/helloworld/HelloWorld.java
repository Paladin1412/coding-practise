package helloworld;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-03-27 19:23
 **/
public class HelloWorld {
    public static void main(String []args) {
        Base b =new Base(1);
        System.out.println(b.getValue());
        System.out.println(b);
        test(b);
        System.out.println(b.getValue());
    }
    static void test(Base base){
        System.out.println(base);
        base = new Base(2);
    }
}
class Base{
    private int m_value;
    Base(int value){
        m_value = value;
    }
    int getValue(){
        return m_value;
    }
}