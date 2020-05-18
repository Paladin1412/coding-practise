package oop.demo05;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 23:55
 **/
public class Application {
    public static void main(String[] args) {
        Outer outer = new Outer();

        // 通过外部类实例化内部类
        Outer.Inner inner = outer.new Inner();
        inner.in();
        inner.getID();

        UserService userService = new UserService() {
            @Override
            public void hello() {

            }
        };
    }
}

interface UserService {
    void hello();
}
