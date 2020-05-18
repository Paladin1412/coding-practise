package exception;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-17 00:42
 **/
// 自定义异常类
public class MyException extends Exception {
    private int detail;

    public MyException(int a) {
        this.detail = a;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
