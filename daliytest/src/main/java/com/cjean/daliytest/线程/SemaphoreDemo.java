package com.cjean.daliytest.线程;

/**
 * @ClassName:SemaphoreDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-04
 */


import java.util.concurrent.Semaphore;

/***
 * @Description:
 * @param: S emaphore 翻译成字面意思为 信号量，Semaphore 可以控制同时访问的线程个数，通过
 * acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 * @return:
 * @author: chu_c
 * @date: 2019-11-04
 */
public class SemaphoreDemo {
    /***
     * @Description:若一个工厂有5 台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完
     * 了，其他工人才能继续使用。那么我们就可以通过 Semaphore 来实现：
     * @param: [args]
     * @return: void
     * @author: chu_c
     * @date: 2019-11-04
     */


    public static void main(String[] args) {
        /****
         ======线程工人：0，正在获取线程许可，2秒钟后释放========
         ======线程工人：1，正在获取线程许可，2秒钟后释放========
         ======线程工人：2，正在获取线程许可，2秒钟后释放========
         ======线程工人：0，正在释放线程许可========
         ======线程工人：3，正在获取线程许可，2秒钟后释放========
         ======线程工人：2，正在释放线程许可========
         ======线程工人：1，正在释放线程许可========
         ======线程工人：5，正在获取线程许可，2秒钟后释放========
         ======线程工人：4，正在获取线程许可，2秒钟后释放========
         ======线程工人：3，正在释放线程许可========
         ======线程工人：6，正在获取线程许可，2秒钟后释放========
         ======线程工人：5，正在释放线程许可========
         ======线程工人：4，正在释放线程许可========
         ======线程工人：7，正在获取线程许可，2秒钟后释放========
         ======线程工人：8，正在获取线程许可，2秒钟后释放========
         ======线程工人：6，正在释放线程许可========
         ======线程工人：9，正在获取线程许可，2秒钟后释放========
         ======线程工人：8，正在释放线程许可========
         ======线程工人：7，正在释放线程许可========
         ======线程工人：9，正在释放线程许可========
         */
        int num = 10;
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < num; i++) {
            new Workss(i, semaphore).start();
        }

    }
   static class Workss extends Thread {
        private int num;
        private Semaphore semaphore;

       public Workss(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("======线程工人：" + num + "，正在获取线程许可，2秒钟后释放========");
                Thread.sleep(2000);
                semaphore.release();
                System.out.println("======线程工人：" + num + "，正在释放线程许可========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

