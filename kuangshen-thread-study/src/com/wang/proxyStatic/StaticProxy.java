package com.wang.proxyStatic;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-05-19 22:33
 **/
//静态代理模式总结
//代理对象和代理对象都要实现同一个接口
//代理对象要代理真实角色
//好处
//代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

//真实角色
class You implements Marry {
    @Override
    public void happyMarry() {
        System.out.println("happyMarry");
    }
}

//代理角色
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("after");
    }

    private void before() {
        System.out.println("before");
    }
}
