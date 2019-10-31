package com.cjean.daliytest.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock {
	
	private Lock lock = new ReentrantLock();
	
//	Lock lock = new ReentrantLock(true); //公平锁
//	Lock lock = new ReentrantLock(false);// 非公平锁
	
	private Condition condition = lock.newCondition();//创建condition对象
	
	public void testMethod() {
		try {
			lock.lock();
			// 1.通过wait方法等待
			System.out.println("await等待");
			condition.await();
			//只有通过lock枷锁，才能进行condition 等待阻塞状态
			
			//2. 通过signal、signalAll唤醒 从新进行竞争队列
			condition.signal();
			for(int i=0;i<5;i++) {
				System.err.println("线程名称："+Thread.currentThread().getName()+"----"+i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
	}

	public static void main(String[] args) {
		new MyReentrantLock().testMethod();
	}
	

}
