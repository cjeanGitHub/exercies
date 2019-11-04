package com.cjean.daliytest.�߳�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName:SorftThreadDemo
 * @Description: ʹ�߳�����ִ��
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

        //ʹ��join�ֶ���ʵ���̵߳��������
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
            System.out.println("====��ǰִ�е��߳���==" + key + "========");
        }
    }

    //ʹ��join�ֶ���ʵ���̵߳��������
    static class Work implements Runnable {
        private Thread thread;

        public Work(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {

            if (thread != null) {
                //����̲߳��ǿյľ�ȥִ�� ��ӷ��� t1ֱ�Ӿ�ȥִ���߳��ˣ���������t2������cpuʱ��Ƭ�Ŀ��ܣ�������ʵ��t2ʱ����t1��ӵ�t2ǰ�棬
                //����t2���ǿյģ����Ծʹ���t3������t2ʱ��Ƭ�Ŀ��ܣ�����ֱ�ӽ�t2��ӵ�t3ǰ����
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
            System.out.println("====��ǰִ�е��߳���==" + Thread.currentThread().getName() + "========");
        }

    }
}

