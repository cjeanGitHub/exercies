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

import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * @author 14172
 * @create 2019/12/9
 * @since 1.0.0
 */
public class PhaserDemo {

    static class MarriPharee extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    return false;
            }
            return false;
        }
    }

    // ��Ա�μӻ��������
    class Person implements Runnable{
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
            System.out.printf("%$ �μӻ���! \n",name);

        }


        @Override
        public void run() {

        }
    }
}




