package com.cjean.daliytest.Ïß³Ì;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author hjm
 * @Date 2019/11/8 22:02
 */
public class PrintThreadDemo {
    static Thread t1;
    static Thread t2;
    static boolean f = false;

    private static ExecutorService es = Executors.newFixedThreadPool(100);
    public static void main(String[] args) throws InterruptedException {

    }

    public synchronized void test(){
        String str1 = "abcdef";
        String str2 = "123456";

        final Object lock = new Object();
        t1 = new Thread(()->{
            for (int i = 0; i < str1.length(); i++) {
                synchronized (lock) {
                    try {
//                        lock.notify();
                        if (f)  lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("cu = [" + str1.charAt(i) + "]");
                    f = true;
                    lock.notify();
                }
            }
        },"t1");

        t2 = new Thread(()->{
            for (int i = 0; i < str2.length(); i++) {
                synchronized (lock) {
                    try {
                        if (!f)  lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("cu = [" + str2.charAt(i) + "]");
                    f = false;
                    lock.notify();
                }
            }
        },"t2");

        t2.start();
        t1.start();
    }
}
