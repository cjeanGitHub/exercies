package com.cjean.daliytest.线程.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName:ThreadLocalDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-11
 */

public class ThreadLocalDemo {

    public static void main(String[] args) throws Exception {
//        threadLoclDem3();

            threadLoclDemo2();
//        threadLoclDemo1();

    }
    /***
    * @Description:.
     *      通过 ThreadLocl  本地线程存储 实现多线程下的 线程只是用本地线程变量的功能  将线程的变量交给ThreadLocal 本地线程存储
     *      来管理线程的本地变量  方式多线程中变量使用权不可控的情景
     *
    * @param: []
    * @return: void
    * @author: chu_c
    * @date: 2019-11-11
    */
    public static void threadLoclDem3() throws InterruptedException {
        ThreadLocal<ThreadLocalApple> threadLocal = new ThreadLocal<>();

        class AppRunn implements Runnable{
            private int threadId;
            public AppRunn(int threadId){
                this.threadId = threadId;
            }

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    threadLocal.set(new ThreadLocalApple(threadId));
                    Thread.yield();
                    System.out.println("======"+this+"========");
                }
            }

            @Override
            public String toString() {
                return "#"+threadId+"-->"+threadLocal.get().getAppleId();
            }
        }
//创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<5;i++){
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);
        executorService.isShutdown();
    }

    /***
     * @Description:
     *          通过加锁的方式 实现每个线程仅仅会取到自己线程中的 苹果id
     *              就是一个人把苹果放上去，然后霸占着桌子，不让别人放。
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-11
     */
    public static void threadLoclDemo2() throws InterruptedException {
        ThreadLocalApple threadLocalApple = new ThreadLocalApple();//实例化一个 线程内的标志对象
        //创建 线程 对实例对象进行标志（即将标志对象放置在多线程空间中
        class AppRunn implements Runnable {
            final int threadId;
            public AppRunn(int threadId) {
                this.threadId = threadId;
            }

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    synchronized (threadLocalApple) {
                        threadLocalApple.setAppleId(threadId);
                        Thread.yield();
                        System.out.println("======" + this + "========");
                    }
                }
            }

            @Override
            public String toString() {
                return "#" + threadId + "-->" + threadLocalApple.getAppleId();
            }
        }

        //创建线程池进行多线程 共享变量的操作
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);

        executorService.isShutdown();
    }

    /***
     * @Description:
     *          在多并发下  多线程对共享变量的操作是无序的  是有问题的
     *          无法做到 线程去操作自己的变量 很大可能会去操作别的线程所使用的的变量
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-11
     */
    public static void threadLoclDemo1() throws InterruptedException {
        ThreadLocalApple threadLocalApple = new ThreadLocalApple();//实例化一个 线程内的标志对象

        //创建 线程 对实例对象进行标志（即将标志对象放置在多线程空间中

        class AppRunn implements Runnable {
            final int threadId;

            public AppRunn(int threadId) {
                this.threadId = threadId;
            }

            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    threadLocalApple.setAppleId(threadId);
                    Thread.yield();
                    System.out.println("======" + this + "========");
                }
            }

            @Override
            public String toString() {
                return "#" + threadId + "-->" + threadLocalApple.getAppleId();
            }
        }

        //创建线程池进行多线程 共享变量的操作
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);

        executorService.isShutdown();
    }

}
