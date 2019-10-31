package com.cjean.daliytest.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chu_c
 * 
 *  ReentrantLock
 *  在jdk中独占锁除了synchronized关键字，还有reentrantlock实现类，他比之syn有着更丰富的方法的好处，
 *  但是也有需要自主加锁、解锁的麻烦 
 */
public class TestReentrantLock {

	public static void main(String[] args) {
		new ConcurrentHashMap<>();
		ReentrantLock reentrantLockFales = new ReentrantLock();//直接构造方法，返回非公平锁，对线程进行随机加锁
//		ReentrantLock reentrantLockTrue = new ReentrantLock(true);//默认是公平锁的，就是队列，谁先来谁先加锁执行代码
		
		
		
		
		 
		
	}

}
