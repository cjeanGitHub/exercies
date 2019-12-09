package com.cjean.daliytest.�߳�;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName:CyclicBarrierDemo
 * @Description:������˼�ػ�դ����ͨ��������ʵ����һ���̵߳ȴ���ĳ��״̬֮����ȫ��ͬʱִ�С�
 * �����ػ� ����Ϊ�����еȴ��̶߳����ͷ��Ժ�CyclicBarrier ���Ա����á��������Ұ����״̬�ͽ���
 * barrier�������� await()����֮���߳̾ʹ��� barrier �ˡ�
 * @author: chu_c
 * @date: 2019-11-04
 */

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
        // ��һ������Ϊ4��դ����ÿ�ν����ͷ�4���̣߳�ÿ�α�1�� ��4�ٵ��߳����͵õ�������4����������ܷ���
        // ��ζ��ֻ��4�ı������̲߳���ʵ���߳�ȫ����ɣ�Ҫ��Ȼ��һֱwait ��������4���̣߳�
        CyclicBarrier barrier = new CyclicBarrier(4);

        // ��i<4 ������������  i<7ʱ����һֱ������  i<8�ǿ�������
        for (int i = 0; i < 8; i++) {
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
