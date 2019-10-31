package com.cjean.daliytest.线程;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 多线程并发协作1--管程法  4个组成部分  解决多并发的模式  生产者消费者模式
 * 
 * 
 * 通过缓冲区 解决高并发协作
 * 
 * @author Cjean
 *
 */
public class CooperationThread1 {

	public static void main(String[] args) throws InterruptedException {
		SynContainer synContainer = new SynContainer();
		new Product(synContainer).start();
		new Consumer(synContainer).start();
 
	}
}
// 生产者
class Product extends Thread{
	SynContainer synContainer;
	
	public Product(SynContainer synContainer) {
		this.synContainer = synContainer;
	}
	@Override
	public void run() {
//		SynContainer synContainer = new SynContainer();//  在练习过程中  定义了一个局部变量 造成 main中执行线程 count始终为0  容器中始终为null
		for(int i=0;i<100;i++) {
			SteamdeBun s = new SteamdeBun(""+i);
			synContainer.push(s);
			System.out.println("生产馒头："+i);
		}
		System.out.println("生产馒头：===");
		System.out.println("生产馒头：===");
	}
}
// 消费者
class Consumer extends Thread{
	static SynContainer synContainer;
	public Consumer(SynContainer synContainer) {
		this.synContainer = synContainer;
		System.out.println("消费馒头：Consumer");
	}
	@Override
	public void run() {
		System.out.println("消费馒头：");
		for(int i=0;i<100;i++) {
			System.out.println("消费馒头："+synContainer.pop().id);
		}
	}
}
// 并发容器
class SynContainer{
	//存储对象
	SteamdeBun[] steamdeBunArr = new SteamdeBun[10];
	int count = 0;
	
	//放入存储对象
	public synchronized void push(SteamdeBun steamdeBun) {
		System.out.println("push-count"+count);
		System.out.println("长度："+steamdeBunArr.length);
		System.out.println("长度2："+count);
		while(count == steamdeBunArr.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		steamdeBunArr[count] = steamdeBun;
		count++;
	}
	// 取出存入对象
	public synchronized SteamdeBun pop(){
		System.out.println("pop-count"+count);
		while(0 == count) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		count--;
		SteamdeBun steamdeBun = steamdeBunArr[count];
		return steamdeBun;
	}
}
// 消费对象
class SteamdeBun{
	String id;

	public SteamdeBun(String id) {
		this.id = id;
	}
}

