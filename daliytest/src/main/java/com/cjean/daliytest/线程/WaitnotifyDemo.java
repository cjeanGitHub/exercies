package com.cjean.daliytest.�߳�;

/**
 * @ClassName:WaitnotifyDemo
 * @Description:
 * @author: chu_c
 * @date: 2019-11-05
 */

public class WaitnotifyDemo {
    public static void main(String[] args) {
        final Sweethearts sweethearts = new Sweethearts();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    sweethearts.boy(i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    sweethearts.gitl(i);
                }
            }
        }).start();
    }


}

class Sweethearts {
    boolean f = false;

    synchronized void boy(int i) {

        //���Ů��û��ڨ ��˵��  �͵���
        while (!f){
            try {
                System.out.println("======�ȴ�Ů����ڨ========");
                this.wait();
                System.out.println("======Ů����ڨ��...========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Ů����ڨ��  �ش�
        System.out.println("======���þ��===���=====");
        f=false;
        this.notify();
    }

    synchronized void gitl(int i) {

        //���˧��ش��� �͵ȴ�
        while (f){
            try {
                System.out.println("======ż��˧��========");
                this.wait();
                System.out.println("======˧���ڨ��...========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("======ż��˧��====��˵��====");
        f=true;
        this.notify();
    }

}