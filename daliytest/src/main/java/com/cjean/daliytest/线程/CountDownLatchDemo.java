package com.cjean.daliytest.线程;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName:CountDownLatchDemo
 * @Description:CountDownLatch类位于java.util.concurrent 包下，利用它可以实现类似计数器的功能。比如有
 * 一个任务 A，它要等待其他 4 个任务执行完毕之后才能执行，此时就可以利用 CountDownLatch
 * 来实现这种功能了。
 * @author: chu_c
 * @date: 2019-11-04
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {

                            System.out.println("======" + Thread.currentThread().getName() + "====正在执行====");
                            Thread.sleep(2000);
                            System.out.println("======" + Thread.currentThread().getName() + "====执行完毕====");
                            latch.countDown();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("======" + Thread.currentThread().getName() + "====正在执行====");
                            Thread.sleep(2000);
                            System.out.println("======" + Thread.currentThread().getName() + "====执行完毕====");
                            latch.countDown();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        System.out.println("等待 2 个子线程执行完毕...");
        latch.await();// 线程数没有countdown 0 ，我得把线程们拦住
        System.out.println("2 个子线程已经执行完毕");
        System.out.println("继续执行主线程");
    }
}

