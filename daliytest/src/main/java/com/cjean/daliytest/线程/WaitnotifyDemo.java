package com.cjean.daliytest.线程;

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

        //如果女孩没搭讪 不说话  就等着
        while (!f){
            try {
                System.out.println("======等待女孩搭讪========");
                this.wait();
                System.out.println("======女孩搭讪啦...========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //女孩搭讪了  回答
        System.out.println("======你好镁铝===你好=====");
        f=false;
        this.notify();
    }

    synchronized void gitl(int i) {

        //如果帅哥回答了 就等带
        while (f){
            try {
                System.out.println("======偶遇帅哥========");
                this.wait();
                System.out.println("======帅哥搭讪啦...========");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("======偶遇帅哥====先说话====");
        f=true;
        this.notify();
    }

}