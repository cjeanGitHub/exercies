package com.cjean.daliytest.�߳�;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
	//��� Ʊ��5
	private static AtomicInteger atomicInteger = new AtomicInteger(5);

	public static void main(String[] args) {

		for(int i=0;i<5;i++) {
			new Thread(()->{
				//ÿ���̻߳�ȡһ��Ʊ
				try {
					Thread.sleep(2000);
					Integer tol = atomicInteger.get();
					Integer left = atomicInteger.decrementAndGet();
					if(left<1) {
						return;
					}
					// Ϊʲôʹ��err ��������out  ��ӦΪ err��ͬ����  out�ǵȴ��ڴ����˲Ž������
					System.err.println(Thread.currentThread().getName()+"��ȡ��һ��Ʊ");

					System.err.println("��ʣ��Ʊ��(left)��"+(left));
					System.err.println("��ʣ��Ʊ��(tol)��"+(tol));
					System.err.println("��ʣ��Ʊ��(tol-left)��"+(tol-left));
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}).start();
		}
	}
	
	

}
