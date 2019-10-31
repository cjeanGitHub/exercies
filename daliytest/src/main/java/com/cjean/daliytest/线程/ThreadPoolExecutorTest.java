package com.cjean.daliytest.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
	public static void testFixedPool() {
		//实例化一个3个线程的线程池
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<10;i++) {
			try {
				// sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
//				}
//			});
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
//				}
//			});
		}
		
	}
	
	public static void testCachedPool(){
		//创建一个线程池
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//将实现runnable接口的 线程放入线程池中
		
		for(int i=0;i<10;i++) {
//			try {
//				// sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("正在运行的是线程池中的线程："+Thread.currentThread().getName());
				}
			});
		}
		
		
		
		
		// 创建一个可缓存线程池
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		ExecutorService cachedThreadPool2 = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			try {
//				// sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//			
//			cachedThreadPool2.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//			
//			cachedThreadPool2.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//			
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// 打印正在执行的缓存线程信息
//					System.out.println(Thread.currentThread().getName() + "：正在被执行");
//				}
//			});
//		}
	}
	
	
	public static void main(String[] args) {
		testFixedPool();
	}
}