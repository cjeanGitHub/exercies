package com.cjean.daliytest.sync.bank;

/**
 * @ClassName:Account
 * @Description:
 * �����˻�  ÿ���߳�����һԪ
 * @author: chu_c
 * @date: 2019-11-05
 */

public class Account {

    private double balance = 0;//���

    //ֱ���� �˻�����Ǯ�ķ���  ���ǽ�ʵ��������м�������
//    public synchronized void deposi(double money){
//        balance += money;
//    }

    public void deposi(double money){
        synchronized ("1"){//��ס�����  ��ס����ִ��ҵ��Ĵ���� ʵ�� ���̹߳��ܵļ���
            balance += money;
        }
    }

    public double getBalance() {
        return balance;
    }
}
