package com.wang.syn;

/**
 * @Description: 不安全的取钱
 * @Author: wangyinghao_sx
 * @Date: 2020-05-20 11:21
 **/
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account, 50, "you");
        Drawing girl = new Drawing(account, 100, "girl");
        you.start();
        girl.start();

    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


class Drawing extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "-->钱不够");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money = account.money - drawingMoney;
            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为" + account.money);
            System.out.println(this.getName() + "手上的钱" + nowMoney);
//        Thread.currentThread().getName()  =====  this.getName() 当前类继承了Thread
        }
    }
}