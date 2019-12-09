/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: SynchDemo
 * Author:   14172
 * Date:     2019/12/9 11:51
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.�߳�;

/**
 * @author 14172
 * @create 2019/12/9
 * @since 1.0.0
 */
public class SynchDemo {

    private final String s1 = new String("SynchDemo01");
    private final String s2 = new String("SynchDemo02");

    //��֤���Ŀ�������
    synchronized void m1() {
        System.out.println("m1...��ʼ");
        for (int i = 0; i < 5; i++) {
            System.out.println("�����" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            ���Ŀ�������
            if (2 == i) {
                m2();
            }
        }
        System.out.println("m1...����");
    }


    synchronized void m2() {
        System.out.println("m2...��ʼ");
        System.out.println("m........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2...����");
    }

    void m3() {
        synchronized (s1) {
            System.out.println("m1...��ʼ");
            for (int i = 0; i < 5; i++) {
                System.out.println("�����" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //���Ŀ�������
            if (2 == i) {
                m2();
            }
            }
            System.out.println("m1...����");
        }
    }

    void m4() {
        System.out.println("m2...��ʼ");
        synchronized (s2) {
            System.out.println("m........");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2...����");
    }

    public static void main(String[] args) {
        SynchDemo synchDemo = new SynchDemo();

        /*new Thread(synchDemo::m1).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(synchDemo::m2).start();*/

        new Thread(synchDemo::m3).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(synchDemo::m4).start();


    }

}


