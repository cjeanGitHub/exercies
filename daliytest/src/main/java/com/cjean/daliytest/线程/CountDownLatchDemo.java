package com.cjean.daliytest.�߳�;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName:CountDownLatchDemo
 * @Description:CountDownLatch��λ��java.util.concurrent ���£�����������ʵ�����Ƽ������Ĺ��ܡ�������
 * һ������ A����Ҫ�ȴ����� 4 ������ִ�����֮�����ִ�У���ʱ�Ϳ������� CountDownLatch
 * ��ʵ�����ֹ����ˡ�
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

                            System.out.println("======" + Thread.currentThread().getName() + "====����ִ��====");
                            Thread.sleep(2000);
                            System.out.println("======" + Thread.currentThread().getName() + "====ִ�����====");
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
                            System.out.println("======" + Thread.currentThread().getName() + "====����ִ��====");
                            Thread.sleep(2000);
                            System.out.println("======" + Thread.currentThread().getName() + "====ִ�����====");
                            latch.countDown();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        System.out.println("�ȴ� 2 �����߳�ִ�����...");
        latch.await();// �߳���û��countdown 0 ���ҵð��߳�����ס
        System.out.println("2 �����߳��Ѿ�ִ�����");
        System.out.println("����ִ�����߳�");
    }
}

