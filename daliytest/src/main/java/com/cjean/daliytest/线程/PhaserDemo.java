/**
 * Copyright (C), 2015-2019, XXX���޹�˾
 * FileName: PhaserDemo
 * Author:   14172
 * Date:     2019/12/9 16:25
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.cjean.daliytest.�߳�;

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
                    System.out.println("�����˶������ˣ�������..."+registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("�����˶������ˣ��ó���..."+registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("�����˶��뿪�ˣ���������׼��������..."+registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("��������ȥ������ȥ��..."+registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }

    // ��Ա�μӻ��������
    static class Person implements Runnable{
        private String name;

        public Person(String name) {
            this.name = name;
        }

        //���μӻ���
        void come(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s �μӻ���! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //�Է���
        void eat(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s �Է���! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //����ó���
        void leaf(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("%s ����ó���! \n",name);
            marriPharee.arriveAndAwaitAdvance();
        }

        //�������� ����
        void hug(){
            if (StringUtil.isNotEmpty(name) && (name.equals("����") || name.equals("����"))){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s ����! \n",name);
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
            new Thread(new Person("����"+i)).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Person("����")).start();
        new Thread(new Person("����")).start();
    }
}




