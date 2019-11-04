package com.cjean.daliytest.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName:SorftThreadDemo
 * @Description: 使线程有序执行
 * @author: chu_c
 * @date: 2019-11-04
 */

public class SorftThreadDemo {

    private static ExecutorService es = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Work2("1"));
        Thread thread2 = new Thread(new Work2("2"));
        Thread thread3 = new Thread(new Work2("3"));

        es.submit(thread1);
        es.submit(thread2);
        es.submit(thread3);

        es.submit(new Work2("1"));
        es.submit(new Work2("2"));
        es.submit(new Work2("3"));

        es.shutdown();

        //使用join字段来实现线程的有序进行
//        Thread thread1 = new Thread(new Work(null));
//        Thread thread2 = new Thread(new Work(thread1));
//        Thread thread3 = new Thread(new Work(thread2));
//
//        thread1.start();
//        thread2.start();
//        thread3.start();

    }

    static class Work2 implements Runnable{

        private String key;

        public Work2(String key){
            this.key = key;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                excute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void excute() {
            System.out.println("====当前执行的线程是==" + key + "========");
        }
    }

    //使用join字段来实现线程的有序进行
    static class Work implements Runnable {
        private Thread thread;

        public Work(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {

            if (thread != null) {
                //如果线程不是空的就去执行 插队方法 t1直接就去执行线程了，但是又有t2先抢到cpu时间片的可能，所以在实例t2时，将t1插队到t2前面，
                //由于t2不是空的，所以就存在t3竞争到t2时间片的可能，所以直接将t2插队到t3前面了
                try {
                    thread.join();
                    excute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                excute();
            }

        }

        public void excute() {
            System.out.println("====当前执行的线程是==" + Thread.currentThread().getName() + "========");
        }

    }
}

