/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ReadWriteLockDemo
 * Author:   14172
 * Date:     2019/12/9 16:49
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.线程;

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
    //读锁 可以允许其他读锁一起进去（共享锁）
    static Lock readLock = readWriteLock.readLock();
    //写锁 不允许其他读锁一起进去（排他锁）
    static Lock writeLock = readWriteLock.writeLock();

    static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("读完了....");
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
            System.out.println("写完了....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //读写次数 总共20次
        int readCount = 18;
        int writeCount = 2;
        //由于是一把锁，无论是每个线程都要一个一个进去 得使用20秒钟
//        Runnable readRun = ()->read(reentrantLock);
//        Runnable writeRun = ()->write(reentrantLock,new Random().nextInt());

        //由于是一把读写锁，读是共享锁，允许多个线程同时进入，所以就不需要18秒了，
        // 但是写锁是排它锁，一次只能一个线程，所以还是耗时2秒
        //总耗时 4秒左右
        Runnable readRun = () -> read(readLock);
        Runnable writeRun = () -> write(writeLock, new Random().nextInt());

        for (int i = 0; i < readCount; i++) new Thread(readRun).start();
        for (int i = 0; i < writeCount; i++) new Thread(writeRun).start();

    }


}
