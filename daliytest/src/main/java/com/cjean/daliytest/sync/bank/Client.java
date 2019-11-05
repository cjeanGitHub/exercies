package com.cjean.daliytest.sync.bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName:Client
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class Client {



    //没有加锁  线程执行100次总有不是100块钱的情况
    public static void first1(){
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Account account = new Account();
        for(int i=0;i<100;i++){
            executorService.submit(new AddMoneyThread(account,1));
        }
        executorService.shutdown();

        //isTerminated 当所有的 线程全部执行完返回 true 否则返回false
        while(!executorService.isTerminated()) { }//System.out.println("没结束呢！");
        System.out.println("======"+account.getBalance()+"========");
    }

    public static void main(String[] args){
        for(int i=0;i<100;i++){
            first1();
        }
    }

    public static void first(){
        Account account = new Account();
        for(int i=0;i<100;i++){
            account.deposi(1);
        }
        System.out.println("======"+account.getBalance()+"========");
    }
}
