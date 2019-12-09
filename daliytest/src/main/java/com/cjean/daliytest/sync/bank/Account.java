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

    // ���ñ����޸ģ���ʵ���ǲ����ñ����޸ĵ�ԭ��
    private final Object syncObj = new Object();

    //ֱ���� �˻�����Ǯ�ķ���  ���ǽ�ʵ��������м�������
//    public synchronized void deposi(double money){
//        balance += money;
//    }

    public void deposi(double money){
        synchronized (syncObj){//��ס�����  ��ס����ִ��ҵ��Ĵ���� ʵ�� ���̹߳��ܵļ���
            balance += money;
        }
    }

    public double getBalance() {
        return balance;
    }
}
