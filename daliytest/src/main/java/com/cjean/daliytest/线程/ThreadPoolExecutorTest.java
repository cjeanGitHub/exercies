package com.cjean.daliytest.�߳�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
	public static void testFixedPool() {
		//ʵ����һ��3���̵߳��̳߳�
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<10;i++) {
			try {
				// sleep�����Կ���ʹ�õ����̳߳�������ǰ���̣߳�û�д����µ��߳�
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
//				}
//			});
//			fixedThreadPool.execute(new Runnable() {
//				public void run() {
//					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
//				}
//			});
		}
		
	}
	
	public static void testCachedPool(){
		//����һ���̳߳�
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//��ʵ��runnable�ӿڵ� �̷߳����̳߳���
		
		for(int i=0;i<10;i++) {
//			try {
//				// sleep�����Կ���ʹ�õ����̳߳�������ǰ���̣߳�û�д����µ��߳�
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
			newCachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println("�������е����̳߳��е��̣߳�"+Thread.currentThread().getName());
				}
			});
		}
		
		
		
		
		// ����һ���ɻ����̳߳�
//		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//		ExecutorService cachedThreadPool2 = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			try {
//				// sleep�����Կ���ʹ�õ����̳߳�������ǰ���̣߳�û�д����µ��߳�
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//			
//			cachedThreadPool2.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//			
//			cachedThreadPool2.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//			
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//			cachedThreadPool.execute(new Runnable() {
//				public void run() {
//					// ��ӡ����ִ�еĻ����߳���Ϣ
//					System.out.println(Thread.currentThread().getName() + "�����ڱ�ִ��");
//				}
//			});
//		}
	}
	
	
	public static void main(String[] args) {
		testFixedPool();
	}
}