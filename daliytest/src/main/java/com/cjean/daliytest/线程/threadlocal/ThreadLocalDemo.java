package com.cjean.daliytest.�߳�.threadlocal;

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
     *      ͨ�� ThreadLocl  �����̴߳洢 ʵ�ֶ��߳��µ� �߳�ֻ���ñ����̱߳����Ĺ���  ���̵߳ı�������ThreadLocal �����̴߳洢
     *      �������̵߳ı��ر���  ��ʽ���߳��б���ʹ��Ȩ���ɿص��龰
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
//�����̳߳�
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<5;i++){
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);
        executorService.isShutdown();
    }

    /***
     * @Description:
     *          ͨ�������ķ�ʽ ʵ��ÿ���߳̽�����ȡ���Լ��߳��е� ƻ��id
     *              ����һ���˰�ƻ������ȥ��Ȼ���ռ�����ӣ����ñ��˷š�
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-11
     */
    public static void threadLoclDemo2() throws InterruptedException {
        ThreadLocalApple threadLocalApple = new ThreadLocalApple();//ʵ����һ�� �߳��ڵı�־����
        //���� �߳� ��ʵ��������б�־��������־��������ڶ��߳̿ռ���
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

        //�����̳߳ؽ��ж��߳� ��������Ĳ���
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);

        executorService.isShutdown();
    }

    /***
     * @Description:
     *          �ڶಢ����  ���̶߳Թ�������Ĳ����������  ���������
     *          �޷����� �߳�ȥ�����Լ��ı��� �ܴ���ܻ�ȥ��������߳���ʹ�õĵı���
     * @param: []
     * @return: void
     * @author: chu_c
     * @date: 2019-11-11
     */
    public static void threadLoclDemo1() throws InterruptedException {
        ThreadLocalApple threadLocalApple = new ThreadLocalApple();//ʵ����һ�� �߳��ڵı�־����

        //���� �߳� ��ʵ��������б�־��������־��������ڶ��߳̿ռ���

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

        //�����̳߳ؽ��ж��߳� ��������Ĳ���
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new AppRunn(i));
        }
        TimeUnit.SECONDS.sleep(1);

        executorService.isShutdown();
    }

}
