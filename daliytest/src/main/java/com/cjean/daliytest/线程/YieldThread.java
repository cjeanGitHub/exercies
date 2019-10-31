package com.cjean.daliytest.线程;

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
				System.out.println("父亲在想买啥烟，"+i+"秒过去了...");
			} catch (InterruptedException e) {
				System.out.println("父亲不想抽了");
				e.printStackTrace();
			}
			
		}
	}
}

class Father implements Runnable{

	public void run() {
		System.out.println("想抽烟  让儿子去买烟");
		Son son = new Son();
		Thread t1 = new Thread(son);
		t1.start();
		try {
			t1.join();
			System.out.println("接过儿子的烟，零花钱给他");
		} catch (InterruptedException e) {
			System.out.println("儿子跑丢了");
			e.printStackTrace();
		}
	}
	
}
class Son implements Runnable{

	public void run() {
		System.out.println("儿子去买烟");
		System.out.println("儿子去玩会游戏");
		for(int i=0;i<10;i++) {
			System.out.println(i+"秒过去了。。。");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("儿子玩完游戏，去买烟");
	}
	
}