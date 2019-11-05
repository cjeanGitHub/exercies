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



    //û�м���  �߳�ִ��100�����в���100��Ǯ�����
    public static void first1(){
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Account account = new Account();
        for(int i=0;i<100;i++){
            executorService.submit(new AddMoneyThread(account,1));
        }
        executorService.shutdown();

        //isTerminated �����е� �߳�ȫ��ִ���귵�� true ���򷵻�false
        while(!executorService.isTerminated()) { }//System.out.println("û�����أ�");
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
