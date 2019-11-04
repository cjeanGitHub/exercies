package com.cjean.daliytest.�߳�;

/**
 * @ClassName:SemaphoreDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-04
 */


import java.util.concurrent.Semaphore;

/***
 * @Description:
 * @param: S emaphore �����������˼Ϊ �ź�����Semaphore ���Կ���ͬʱ���ʵ��̸߳�����ͨ��
 * acquire() ��ȡһ����ɣ����û�о͵ȴ����� release() �ͷ�һ����ɡ�
 * @return:
 * @author: chu_c
 * @date: 2019-11-04
 */
public class SemaphoreDemo {
    /***
     * @Description:��һ��������5 ̨������������8�����ˣ�һ̨����ͬʱֻ�ܱ�һ������ʹ�ã�ֻ��ʹ����
     * �ˣ��������˲��ܼ���ʹ�á���ô���ǾͿ���ͨ�� Semaphore ��ʵ�֣�
     * @param: [args]
     * @return: void
     * @author: chu_c
     * @date: 2019-11-04
     */


    public static void main(String[] args) {
        /****
         ======�̹߳��ˣ�0�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�1�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�2�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�0�������ͷ��߳����========
         ======�̹߳��ˣ�3�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�2�������ͷ��߳����========
         ======�̹߳��ˣ�1�������ͷ��߳����========
         ======�̹߳��ˣ�5�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�4�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�3�������ͷ��߳����========
         ======�̹߳��ˣ�6�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�5�������ͷ��߳����========
         ======�̹߳��ˣ�4�������ͷ��߳����========
         ======�̹߳��ˣ�7�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�8�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�6�������ͷ��߳����========
         ======�̹߳��ˣ�9�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========
         ======�̹߳��ˣ�8�������ͷ��߳����========
         ======�̹߳��ˣ�7�������ͷ��߳����========
         ======�̹߳��ˣ�9�������ͷ��߳����========
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
                System.out.println("======�̹߳��ˣ�" + num + "�����ڻ�ȡ�߳���ɣ�2���Ӻ��ͷ�========");
                Thread.sleep(2000);
                semaphore.release();
                System.out.println("======�̹߳��ˣ�" + num + "�������ͷ��߳����========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

