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

    // 人员参加婚礼的流程
    class Person implements Runnable{
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
            System.out.printf("%$ 参加婚礼! \n",name);

        }


        @Override
        public void run() {

        }
    }
}




