/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PhaserDemo
 * Author:   14172
 * Date:     2019/12/9 16:25
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjean.daliytest.线程;

import com.cjean.daliytest.util.StringUtil;

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author 14172
 * @create 2019/12/9
 * @since 1.0.0
 */
public class PhaserDemo {

    static MarriPharee marriPharee = new MarriPharee();

    static class MarriPharee extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("所有人都来齐了，开饭吧..."+registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人都吃完了，该撤了..."+registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人都离开了，新郎新娘准备洞房吧..."+registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("新郎新娘去洞房吧去了..."+registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }

    // 人员参加婚礼的流程
    static class Person implements Runnable{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        //来参加婚礼
        void come(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s 参加婚礼! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //吃饭咯
        void eat(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s 吃饭咯! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //吃完该撤了
        void leaf(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s 吃完该撤了! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //新郎新娘 抱抱
        void hug(){
            if (StringUtil.isNotEmpty(name) && (name.equals("新郎") || name.equals("新娘"))){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s 抱抱! \n",name);
                marriPharee.arriveAndAwaitAdvance();
            }else {
                marriPharee.arriveAndDeregister();
            }
        }

        @Override
        public void run() {
            come();
            eat();
            leaf();
            hug();
        }
    }

    public static void main(String[] args) {
        marriPharee.bulkRegister(   7);
        for (int i = 1; i <6 ; i++) {
            new Thread(new Person("朋友"+i)).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }
}




