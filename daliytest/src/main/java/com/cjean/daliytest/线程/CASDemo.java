package com.cjean.daliytest.线程;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
	//库存 票数5
	private static AtomicInteger atomicInteger = new AtomicInteger(5);

	public static void main(String[] args) {

		for(int i=0;i<5;i++) {
			new Thread(()->{
				//每个线程获取一张票
				try {
					Thread.sleep(2000);
					Integer tol = atomicInteger.get();
					Integer left = atomicInteger.decrementAndGet();
					if(left<1) {
						return;
					}
					// 为什么使用err 而不是用out  是应为 err是同步的  out是等待内存满了才进行输出
					System.err.println(Thread.currentThread().getName()+"获取了一张票");

					System.err.println("还剩余票数(left)："+(left));
					System.err.println("还剩余票数(tol)："+(tol));
					System.err.println("还剩余票数(tol-left)："+(tol-left));
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}).start();
		}
	}
	
	

}
