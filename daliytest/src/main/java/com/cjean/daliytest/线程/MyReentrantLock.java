package com.cjean.daliytest.�߳�;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
	
//	private Lock lock = new ReentrantLock();
	
//	Lock lock = new ReentrantLock(true); //��ƽ��
//	Lock lock = new ReentrantLock(false);// �ǹ�ƽ��
	
//	private Condition condition = lock.newCondition();//����condition����
	
	public void testMethod() {
		Lock lock = new ReentrantLock();
		try {
			lock.lock();
			// 1.ͨ��wait�����ȴ�
			System.out.println("await�ȴ�");
			//	condition.await();
			//ֻ��ͨ��lock���������ܽ���condition �ȴ�����״̬
			
			//2. ͨ��signal��signalAll���� ���½��о�������
		//	condition.signal();
			for(int i=0;i<5;i++) {
				System.err.println("�߳����ƣ�"+Thread.currentThread().getName()+"----"+i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
			System.out.println("unlock");
		}
		
		
	}

	public static void main(String[] args) {
		new MyReentrantLock().testMethod();
		MyReentrantLock myReentrantLock1 = new MyReentrantLock();
		MyReentrantLock myReentrantLock2 = new MyReentrantLock();
		myReentrantLock1.testMethod();
		myReentrantLock2.testMethod();
	}
	

}
