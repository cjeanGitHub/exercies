/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SynchDemo
 * Author:   14172
 * Date:     2019/12/9 11:51
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.线程;

/**
 * @author 14172
 * @create 2019/12/9
 * @since 1.0.0
 */
public class SynchDemo {

    private final String s1 = new String("SynchDemo01");
    private final String s2 = new String("SynchDemo02");

    //验证锁的可重入行
    synchronized void m1() {
        System.out.println("m1...开始");
        for (int i = 0; i < 5; i++) {
            System.out.println("结果：" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            锁的可重入行
            if (2 == i) {
                m2();
            }
        }
        System.out.println("m1...结束");
    }


    synchronized void m2() {
        System.out.println("m2...开始");
        System.out.println("m........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2...结束");
    }

    void m3() {
        synchronized (s1) {
            System.out.println("m1...开始");
            for (int i = 0; i < 5; i++) {
                System.out.println("结果：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁的可重入行
            if (2 == i) {
                m2();
            }
            }
            System.out.println("m1...结束");
        }
    }

    void m4() {
        System.out.println("m2...开始");
        synchronized (s2) {
            System.out.println("m........");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2...结束");
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


