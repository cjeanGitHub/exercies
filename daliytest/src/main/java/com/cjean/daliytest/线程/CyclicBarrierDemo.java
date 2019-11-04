package com.cjean.daliytest.�߳�;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName:CyclicBarrierDemo
 * @Description:������˼�ػ�դ����ͨ��������ʵ����һ���̵߳ȴ���ĳ��״̬֮����ȫ��ͬʱִ�С������ػ� ����Ϊ�����еȴ��̶߳����ͷ��Ժ�CyclicBarrier ���Ա����á��������Ұ����״̬�ͽ���
 * barrier�������� await()����֮���߳̾ʹ��� barrier �ˡ�
 * @author: chu_c
 * @date: 2019-11-04
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); //��˯����ģ���߳���ҪԤ��д�����ݲ���
                System.out.println("�߳�" + Thread.currentThread().getName() + "д��������ϣ��ȴ������߳�д�����");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("�����߳�д����ϣ����������������񣬱������ݲ���");
        }
    }
}
