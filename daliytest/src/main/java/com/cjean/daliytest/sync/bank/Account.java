package com.cjean.daliytest.sync.bank;

/**
 * @ClassName:Account
 * @Description:
 * 银行账户  每个线程增加一元
 * @author: chu_c
 * @date: 2019-11-05
 */

public class Account {

    private double balance = 0;//余额

    //直接锁 账户增加钱的方法  这是将实例对象进行加锁处理
//    public synchronized void deposi(double money){
//        balance += money;
//    }

    public void deposi(double money){
        synchronized ("1"){//锁住代码块  锁住具体执行业务的代码块 实现 多线程功能的加锁
            balance += money;
        }
    }

    public double getBalance() {
        return balance;
    }
}
