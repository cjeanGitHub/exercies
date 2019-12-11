/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: ExchangerDemo
 * Author:   14172
 * Date:     2019/12/10 10:54
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.�߳�;

import java.util.concurrent.Exchanger;

/**
 * @author 14172
 * @create 2019/12/10
 * @since 1.0.0
 *
 * Exchanger ��������   ֻ��1��2����   3��4����  ����� 1 2 3  1 2 �ύ�� 3�����һ���߳̽��н���
 */
public class ExchangerDemo {
    static Exchanger exchanger = new Exchanger();

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }
    //T3 ��dao һ���̺߳�������
    private static void test05(){
        new Thread(()->{
            String s1 = "s1";
            try {
                s1 = (String) exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s1);
        },"T1").start();

        new Thread(()->{
            String s2 = "s2";
            try {
                s2 = (String) exchanger.exchange(s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s2);
        },"T2").start();


        Runnable r5 = new Runnable() {
            @Override
            public void run() {
                String s5 = "s5";
                try {
                    s5 = (String) exchanger.exchange(s5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+s5);
            }
        };
        Thread t5 = new Thread(r5,"t5");
        t5.start();
        new Thread(()->{
            try {
                t5.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s3 = "s3";
            try {
                s3 = (String) exchanger.exchange(s3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s3);
        },"T3").start();

        new Thread(()->{
            String s4 = "s4";
            try {
                s4 = (String) exchanger.exchange(s4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s4);
        },"T4").start();


    }

    //T3 ��dao һ���̺߳�������
    private static void test04(){
        new Thread(()->{
            String s1 = "s1";
            try {
                s1 = (String) exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s1);
        },"T1").start();
        new Thread(()->{
            String s2 = "s2";
            try {
                s2 = (String) exchanger.exchange(s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s2);
        },"T2").start();
        new Thread(()->{
            String s3 = "s3";
            try {
                s3 = (String) exchanger.exchange(s3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s3);
        },"T3").start();
        new Thread(()->{
            String s4 = "s4";
            try {
                s4 = (String) exchanger.exchange(s4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s4);
        },"T4").start();
    }

    //T3 �ȵȴ� һ���̺߳�������
    private static void test03(){
        new Thread(()->{
            String s1 = "s1";
            try {
                s1 = (String) exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s1);
        },"T1").start();
        new Thread(()->{
            String s2 = "s2";
            try {
                s2 = (String) exchanger.exchange(s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s2);
        },"T2").start();
        new Thread(()->{
            String s3 = "s3";
            try {
                s3 = (String) exchanger.exchange(s3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s3);
        },"T3").start();
    }

    //�ȵ� һ���̺߳�������
    private static void test02(){
        new Thread(()->{
            String s1 = "s1";
            try {
                s1 = (String) exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s1);
        },"T1").start();
        new Thread(()->{
            String s2 = "s2";
            try {
                s2 = (String) exchanger.exchange(s2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s2);
        },"T2").start();
    }

    //t1��һֱ�����ȴ� һ���̺߳�������
    private static void test01(){
        new Thread(()->{
            String s1 = "s1";
            try {
                s1 = (String) exchanger.exchange(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+s1);
        },"T1").start();
    }


}
