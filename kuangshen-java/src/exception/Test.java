package exception;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 00:33
 **/
public class Test {
    public static void main(String[] args) {
        try {
            throw new MyException(10);
        } catch (MyException e) {
            System.out.println("MyException=>" + e);
        }
    }
}

// cmd+opt+T
