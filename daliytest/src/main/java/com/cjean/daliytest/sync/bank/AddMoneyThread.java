package com.cjean.daliytest.sync.bank;

/**
 * @ClassName:AddMoneyThread
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class AddMoneyThread implements Runnable {

    private Account account;

    private double money;

    public AddMoneyThread(Account account,double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
            account.deposi(money);
    }

//    @Override
//    public void run() {
//        synchronized (account){
//            account.deposi(money);
//        }
//
//    }
}
