package com.cjean.daliytest.线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName:CyclicBarrierDemo
 * @Description:字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 * 叫做回环 是因为当所有等待线程都被释放以后，CyclicBarrier 可以被重用。我们暂且把这个状态就叫做
 * barrier，当调用 await()方法之后，线程就处于 barrier 了。
 * @author: chu_c
 * @date: 2019-11-04
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
        // 设一个参数为4的栅栏，每次仅能释放4个线程，每次比1多 比4少的线程数就得等着满足4这个条件才能发行
        // 意味着只有4的倍数的线程才能实现线程全部完成，要不然就一直wait 等满足有4个线程，
        CyclicBarrier barrier = new CyclicBarrier(4);

        // 当i<4 可以正常运行  i<7时运行一直在阻塞  i<8是可以运行
        for (int i = 0; i < 8; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); //以睡眠来模拟线程需要预定写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }
}
