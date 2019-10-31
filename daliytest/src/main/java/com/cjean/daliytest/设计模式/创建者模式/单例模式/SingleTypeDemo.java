package com.cjean.daliytest.设计模式.创建者模式.单例模式;
/**
 * 基于 懒汉式的 单例模式
 * @author Cjean
 *
 */
public class SingleTypeDemo {
	//由于是单例  对外不能new对象 
	private static volatile SingleTypeDemo instance;
	//1.私有化构造器
	private SingleTypeDemo() {
		
	}
	//2.对外提供 静态方法
	public static SingleTypeDemo getInstance() {
		// 由于会出现 引用返回延时问题 所以对 实例对象进行 判断
		if(null != instance) {
			return instance;
		}else {
			// 为防止多线程并发问题 对资源对象进行加锁
			synchronized(SingleTypeDemo.class) {
				if(null == instance) {
					return instance = new SingleTypeDemo();
				}
			}
		}
		return instance;
	}
	

	public static void main(String[] args) {

		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				System.out.println(SingleTypeDemo.getInstance());
			}).start();
			try {
				Thread.sleep(2000);
				System.out.println("2000000");
				System.out.println(SingleTypeDemo.getInstance());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println("-------------------");
		}
		
	}

}
