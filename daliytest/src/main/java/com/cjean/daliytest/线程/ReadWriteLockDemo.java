/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: ReadWriteLockDemo
 * Author:   14172
 * Date:     2019/12/9 16:49
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.�߳�;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 14172
 * @create 2019/12/9
 * @since 1.0.0
 */
public class ReadWriteLockDemo {

    static ReentrantLock reentrantLock = new ReentrantLock();
    static int value;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //���� ����������������һ���ȥ����������
    static Lock readLock = readWriteLock.readLock();
    //д�� ��������������һ���ȥ����������
    static Lock writeLock = readWriteLock.writeLock();

    static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("������....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("д����....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //��д���� �ܹ�20��
        int readCount = 18;
        int writeCount = 2;
        //������һ������������ÿ���̶߳�Ҫһ��һ����ȥ ��ʹ��20����
//        Runnable readRun = ()->read(reentrantLock);
//        Runnable writeRun = ()->write(reentrantLock,new Random().nextInt());

        //������һ�Ѷ�д�������ǹ��������������߳�ͬʱ���룬���ԾͲ���Ҫ18���ˣ�
        // ����д������������һ��ֻ��һ���̣߳����Ի��Ǻ�ʱ2��
        //�ܺ�ʱ 4������
        Runnable readRun = () -> read(readLock);
        Runnable writeRun = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < readCount; i++) new Thread(readRun).start();
        for (int i = 0; i < writeCount; i++) new Thread(writeRun).start();

    }


}
