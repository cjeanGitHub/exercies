package com.cjean.daliytest.�߳�;

public class YieldThread {

	public static void main(String[] args) throws InterruptedException {
		Father father = new Father();
		Think think = new Think();
		Thread t = new Thread(father);
		think.start();
		think.join();
		t.start();
		
	}
}
class Think extends Thread{
	Thread t = new Thread();
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				t.sleep(1000);
				System.out.println("����������ɶ�̣�"+i+"���ȥ��...");
			} catch (InterruptedException e) {
				System.out.println("���ײ������");
				e.printStackTrace();
			}
			
		}
	}
}

class Father implements Runnable{

	public void run() {
		System.out.println("�����  �ö���ȥ����");
		Son son = new Son();
		Thread t1 = new Thread(son);
		t1.start();
		try {
			t1.join();
			System.out.println("�ӹ����ӵ��̣��㻨Ǯ����");
		} catch (InterruptedException e) {
			System.out.println("�����ܶ���");
			e.printStackTrace();
		}
	}
	
}
class Son implements Runnable{

	public void run() {
		System.out.println("����ȥ����");
		System.out.println("����ȥ�����Ϸ");
		for(int i=0;i<10;i++) {
			System.out.println(i+"���ȥ�ˡ�����");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("����������Ϸ��ȥ����");
	}
	
}