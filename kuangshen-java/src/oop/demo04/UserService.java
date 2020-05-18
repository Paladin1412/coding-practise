package oop.demo04;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-16 23:42
 **/
public interface UserService {
    //接口中的所有定义其实都是public abstract

    // 常量 public static final
    int age = 99;

    void add(String name);

    void delete(String name);

    void update(String name);

    void query(String name);
}
